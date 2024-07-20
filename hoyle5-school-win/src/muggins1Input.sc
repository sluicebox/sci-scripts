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
		left 220
		top 40
		right 313
		bottom 146
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
		nsLeft 7
		nsTop 17
		x 7
		y 17
		mainLoop 1
	)
)

(instance one of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 17
		x 23
		y 17
		mainLoop 2
		returnValue 1
	)
)

(instance two of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 17
		x 39
		y 17
		mainLoop 3
		returnValue 2
	)
)

(instance three of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 17
		x 55
		y 17
		mainLoop 4
		returnValue 3
	)
)

(instance four of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 17
		x 71
		y 17
		mainLoop 5
		returnValue 4
	)
)

(instance five of MugginsInputItem
	(properties
		nsLeft 7
		nsTop 31
		x 7
		y 31
		mainLoop 6
		returnValue 5
	)
)

(instance six of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 31
		x 23
		y 31
		mainLoop 7
		returnValue 6
	)
)

(instance seven of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 31
		x 39
		y 31
		mainLoop 8
		returnValue 7
	)
)

(instance eight of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 31
		x 55
		y 31
		mainLoop 9
		returnValue 8
	)
)

(instance nine of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 31
		x 71
		y 31
		mainLoop 10
		returnValue 9
	)
)

(instance ten of MugginsInputItem
	(properties
		nsLeft 7
		nsTop 45
		x 7
		y 45
		mainLoop 1
		mainCel 2
		returnValue 10
	)
)

(instance eleven of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 45
		x 23
		y 45
		mainLoop 2
		mainCel 2
		returnValue 11
	)
)

(instance twelve of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 45
		x 39
		y 45
		mainLoop 3
		mainCel 2
		returnValue 12
	)
)

(instance thirteen of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 45
		x 55
		y 45
		mainLoop 4
		mainCel 2
		returnValue 13
	)
)

(instance fourteen of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 45
		x 71
		y 45
		mainLoop 5
		mainCel 2
		returnValue 14
	)
)

(instance fifteen of MugginsInputItem
	(properties
		nsLeft 7
		nsTop 59
		x 7
		y 59
		mainLoop 6
		mainCel 2
		returnValue 15
	)
)

(instance sixteen of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 59
		x 23
		y 59
		mainLoop 7
		mainCel 2
		returnValue 16
	)
)

(instance seventeen of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 59
		x 39
		y 59
		mainLoop 8
		mainCel 2
		returnValue 17
	)
)

(instance eighteen of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 59
		x 55
		y 59
		mainLoop 9
		mainCel 2
		returnValue 18
	)
)

(instance nineteen of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 59
		x 71
		y 59
		mainLoop 10
		mainCel 2
		returnValue 19
	)
)

(instance twenty of MugginsInputItem
	(properties
		nsLeft 7
		nsTop 73
		x 7
		y 73
		mainLoop 1
		mainCel 4
		returnValue 20
	)
)

(instance twentyOne of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 73
		x 23
		y 73
		mainLoop 2
		mainCel 4
		returnValue 21
	)
)

(instance twentyTwo of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 73
		x 39
		y 73
		mainLoop 3
		mainCel 4
		returnValue 22
	)
)

(instance twentyThree of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 73
		x 55
		y 73
		mainLoop 4
		mainCel 4
		returnValue 23
	)
)

(instance twentyFour of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 73
		x 71
		y 73
		mainLoop 5
		mainCel 4
		returnValue 24
	)
)

(instance twentyFive of MugginsInputItem
	(properties
		nsLeft 7
		nsTop 87
		x 7
		y 87
		mainLoop 6
		mainCel 4
		returnValue 25
	)
)

(instance twentySix of MugginsInputItem
	(properties
		nsLeft 23
		nsTop 87
		x 23
		y 87
		mainLoop 7
		mainCel 4
		returnValue 26
	)
)

(instance twentySeven of MugginsInputItem
	(properties
		nsLeft 39
		nsTop 87
		x 39
		y 87
		mainLoop 8
		mainCel 4
		returnValue 27
	)
)

(instance twentyEight of MugginsInputItem
	(properties
		nsLeft 55
		nsTop 87
		x 55
		y 87
		mainLoop 9
		mainCel 4
		returnValue 28
	)
)

(instance twentyNine of MugginsInputItem
	(properties
		nsLeft 71
		nsTop 87
		x 71
		y 87
		mainLoop 10
		mainCel 4
		returnValue 29
	)
)

