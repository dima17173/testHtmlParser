Methods:
1. findButtonByIdInOriginPage() - this method parse origin page and find element with given id;
2. findButtonNameInCustomPage() - this method find the button with the same name as in origin page;
3. findElementInCustomPage() - this method parse custom page and call method findButtonNameInCustomPage();

To run this program need to call method findElementInCustomPage(<path to your html page>);