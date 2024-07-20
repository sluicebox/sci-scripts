;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 504)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	muggins1Input 0
)

(local
	local0
)

(procedure (localproc_0)
	(EnableCursor)
	(= global491 0)
	(= local0 gGameControls)
	((= gGameControls muggins1InputControls)
		plane: muggins1InputWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: (if (not (HaveMouse)) zero else 0)
		add:
			(zero theObj: zero selector: #doit yourself:)
			(one theObj: one selector: #doit yourself:)
			(two theObj: two selector: #doit yourself:)
			(three theObj: three selector: #doit yourself:)
			(four theObj: four selector: #doit yourself:)
			(five theObj: five selector: #doit yourself:)
			(six theObj: six selector: #doit yourself:)
			(seven theObj: seven selector: #doit yourself:)
			(eight theObj: eight selector: #doit yourself:)
			(nine theObj: nine selector: #doit yourself:)
			(ten theObj: ten selector: #doit yourself:)
			(eleven theObj: eleven selector: #doit yourself:)
			(twelve theObj: twelve selector: #doit yourself:)
			(thirteen theObj: thirteen selector: #doit yourself:)
			(fourteen theObj: fourteen selector: #doit yourself:)
			(fifteen theObj: fifteen selector: #doit yourself:)
			(sixteen theObj: sixteen selector: #doit yourself:)
			(seventeen theObj: seventeen selector: #doit yourself:)
			(eighteen theObj: eighteen selector: #doit yourself:)
			(nineteen theObj: nineteen selector: #doit yourself:)
			(twenty theObj: twenty selector: #doit yourself:)
			(twentyOne theObj: twentyOne selector: #doit yourself:)
			(twentyTwo theObj: twentyTwo selector: #doit yourself:)
			(twentyThree theObj: twentyThree selector: #doit yourself:)
			(twentyFour theObj: twentyFour selector: #doit yourself:)
			(twentyFive theObj: twentyFive selector: #doit yourself:)
			(twentySix theObj: twentySix selector: #doit yourself:)
			(twentySeven theObj: twentySeven selector: #doit yourself:)
			(twentyEight theObj: twentyEight selector: #doit yourself:)
			(twentyNine theObj: twentyNine selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 504)
)

(instance muggins1Input of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance muggins1InputWindow of InvisibleWindow
	(properties
		left 440
		top 50
		right 626
		bottom 304
	)

	(method (init &tmp [temp0 6])
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 504 0 0 0 0 15 self)
	)
)

(instance muggins1InputControls of HoyleGameControls
	(properties)
)

(class MugginsInputItem of ControlIcon
	(properties
		signal 387
		mainView 504
		highlightColor -1
		returnValue 0
	)

	(method (doit)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(= global491 returnValue)
	)

	(method (init)
		(super init: &rest)
	)
)

(instance zero of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 49
		x 19
		y 49
		mainLoop 1
	)
)

(instance one of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 49
		x 49
		y 49
		mainLoop 2
		returnValue 1
	)
)

(instance two of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 49
		x 79
		y 49
		mainLoop 3
		returnValue 2
	)
)

(instance three of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 49
		x 109
		y 49
		mainLoop 4
		returnValue 3
	)
)

(instance four of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 49
		x 139
		y 49
		mainLoop 5
		returnValue 4
	)
)

(instance five of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 80
		x 19
		y 80
		mainLoop 6
		returnValue 5
	)
)

(instance six of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 80
		x 49
		y 80
		mainLoop 7
		returnValue 6
	)
)

(instance seven of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 80
		x 79
		y 80
		mainLoop 8
		returnValue 7
	)
)

(instance eight of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 80
		x 109
		y 80
		mainLoop 9
		returnValue 8
	)
)

(instance nine of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 80
		x 139
		y 80
		mainLoop 10
		returnValue 9
	)
)

(instance ten of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 111
		x 19
		y 111
		mainLoop 1
		mainCel 2
		returnValue 10
	)
)

(instance eleven of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 111
		x 49
		y 111
		mainLoop 2
		mainCel 2
		returnValue 11
	)
)

(instance twelve of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 111
		x 79
		y 111
		mainLoop 3
		mainCel 2
		returnValue 12
	)
)

(instance thirteen of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 111
		x 109
		y 111
		mainLoop 4
		mainCel 2
		returnValue 13
	)
)

(instance fourteen of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 111
		x 139
		y 111
		mainLoop 5
		mainCel 2
		returnValue 14
	)
)

(instance fifteen of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 142
		x 19
		y 142
		mainLoop 6
		mainCel 2
		returnValue 15
	)
)

(instance sixteen of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 142
		x 49
		y 142
		mainLoop 7
		mainCel 2
		returnValue 16
	)
)

(instance seventeen of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 142
		x 79
		y 142
		mainLoop 8
		mainCel 2
		returnValue 17
	)
)

(instance eighteen of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 142
		x 109
		y 142
		mainLoop 9
		mainCel 2
		returnValue 18
	)
)

(instance nineteen of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 142
		x 139
		y 142
		mainLoop 10
		mainCel 2
		returnValue 19
	)
)

(instance twenty of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 173
		x 19
		y 173
		mainLoop 1
		mainCel 4
		returnValue 20
	)
)

(instance twentyOne of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 173
		x 49
		y 173
		mainLoop 2
		mainCel 4
		returnValue 21
	)
)

(instance twentyTwo of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 173
		x 79
		y 173
		mainLoop 3
		mainCel 4
		returnValue 22
	)
)

(instance twentyThree of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 173
		x 109
		y 173
		mainLoop 4
		mainCel 4
		returnValue 23
	)
)

(instance twentyFour of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 173
		x 139
		y 173
		mainLoop 5
		mainCel 4
		returnValue 24
	)
)

(instance twentyFive of MugginsInputItem
	(properties
		nsLeft 19
		nsTop 204
		x 19
		y 204
		mainLoop 6
		mainCel 4
		returnValue 25
	)
)

(instance twentySix of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 204
		x 49
		y 204
		mainLoop 7
		mainCel 4
		returnValue 26
	)
)

(instance twentySeven of MugginsInputItem
	(properties
		nsLeft 79
		nsTop 204
		x 79
		y 204
		mainLoop 8
		mainCel 4
		returnValue 27
	)
)

(instance twentyEight of MugginsInputItem
	(properties
		nsLeft 109
		nsTop 204
		x 109
		y 204
		mainLoop 9
		mainCel 4
		returnValue 28
	)
)

(instance twentyNine of MugginsInputItem
	(properties
		nsLeft 139
		nsTop 204
		x 139
		y 204
		mainLoop 10
		mainCel 4
		returnValue 29
	)
)

