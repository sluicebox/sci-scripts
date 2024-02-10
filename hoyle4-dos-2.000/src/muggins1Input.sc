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
	(HandsOn)
	(= global491 0)
	(= local0 gGameControls)
	((= gGameControls muggins1InputControls)
		window: muggins1InputWindow
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
)

(instance muggins1Input of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance muggins1InputWindow of InvisibleWindow
	(properties
		top 40
		left 220
		bottom 146
		right 313
	)

	(method (open &tmp [temp0 6])
		(super open:)
		(DrawCel 504 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance muggins1InputControls of HoyleGameControls
	(properties)
)

(class MugginsInputItem of ControlIcon
	(properties
		view 504
		signal 387
		highlightColor -1
		returnValue 0
	)

	(method (doit)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
		(= global491 returnValue)
	)
)

(instance zero of MugginsInputItem
	(properties
		loop 1
		cel 0
		nsLeft 7
		nsTop 17
		hiCel 1
	)
)

(instance one of MugginsInputItem
	(properties
		loop 2
		cel 0
		nsLeft 23
		nsTop 17
		hiCel 1
		returnValue 1
	)
)

(instance two of MugginsInputItem
	(properties
		loop 3
		cel 0
		nsLeft 39
		nsTop 17
		hiCel 1
		returnValue 2
	)
)

(instance three of MugginsInputItem
	(properties
		loop 4
		cel 0
		nsLeft 55
		nsTop 17
		hiCel 1
		returnValue 3
	)
)

(instance four of MugginsInputItem
	(properties
		loop 5
		cel 0
		nsLeft 71
		nsTop 17
		hiCel 1
		returnValue 4
	)
)

(instance five of MugginsInputItem
	(properties
		loop 6
		cel 0
		nsLeft 7
		nsTop 31
		hiCel 1
		returnValue 5
	)
)

(instance six of MugginsInputItem
	(properties
		loop 7
		cel 0
		nsLeft 23
		nsTop 31
		hiCel 1
		returnValue 6
	)
)

(instance seven of MugginsInputItem
	(properties
		loop 8
		cel 0
		nsLeft 39
		nsTop 31
		hiCel 1
		returnValue 7
	)
)

(instance eight of MugginsInputItem
	(properties
		loop 9
		cel 0
		nsLeft 55
		nsTop 31
		hiCel 1
		returnValue 8
	)
)

(instance nine of MugginsInputItem
	(properties
		loop 10
		cel 0
		nsLeft 71
		nsTop 31
		hiCel 1
		returnValue 9
	)
)

(instance ten of MugginsInputItem
	(properties
		loop 1
		cel 2
		nsLeft 7
		nsTop 45
		normalCel 2
		hiCel 3
		returnValue 10
	)
)

(instance eleven of MugginsInputItem
	(properties
		loop 2
		cel 2
		nsLeft 23
		nsTop 45
		normalCel 2
		hiCel 3
		returnValue 11
	)
)

(instance twelve of MugginsInputItem
	(properties
		loop 3
		cel 2
		nsLeft 39
		nsTop 45
		normalCel 2
		hiCel 3
		returnValue 12
	)
)

(instance thirteen of MugginsInputItem
	(properties
		loop 4
		cel 2
		nsLeft 55
		nsTop 45
		normalCel 2
		hiCel 3
		returnValue 13
	)
)

(instance fourteen of MugginsInputItem
	(properties
		loop 5
		cel 2
		nsLeft 71
		nsTop 45
		normalCel 2
		hiCel 3
		returnValue 14
	)
)

(instance fifteen of MugginsInputItem
	(properties
		loop 6
		cel 2
		nsLeft 7
		nsTop 59
		normalCel 2
		hiCel 3
		returnValue 15
	)
)

(instance sixteen of MugginsInputItem
	(properties
		loop 7
		cel 2
		nsLeft 23
		nsTop 59
		normalCel 2
		hiCel 3
		returnValue 16
	)
)

(instance seventeen of MugginsInputItem
	(properties
		loop 8
		cel 2
		nsLeft 39
		nsTop 59
		normalCel 2
		hiCel 3
		returnValue 17
	)
)

(instance eighteen of MugginsInputItem
	(properties
		loop 9
		cel 2
		nsLeft 55
		nsTop 59
		normalCel 2
		hiCel 3
		returnValue 18
	)
)

(instance nineteen of MugginsInputItem
	(properties
		loop 10
		cel 2
		nsLeft 71
		nsTop 59
		normalCel 2
		hiCel 3
		returnValue 19
	)
)

(instance twenty of MugginsInputItem
	(properties
		loop 1
		cel 4
		nsLeft 7
		nsTop 73
		normalCel 4
		hiCel 5
		returnValue 20
	)
)

(instance twentyOne of MugginsInputItem
	(properties
		loop 2
		cel 4
		nsLeft 23
		nsTop 73
		normalCel 4
		hiCel 5
		returnValue 21
	)
)

(instance twentyTwo of MugginsInputItem
	(properties
		loop 3
		cel 4
		nsLeft 39
		nsTop 73
		normalCel 4
		hiCel 5
		returnValue 22
	)
)

(instance twentyThree of MugginsInputItem
	(properties
		loop 4
		cel 4
		nsLeft 55
		nsTop 73
		normalCel 4
		hiCel 5
		returnValue 23
	)
)

(instance twentyFour of MugginsInputItem
	(properties
		loop 5
		cel 4
		nsLeft 71
		nsTop 73
		normalCel 4
		hiCel 5
		returnValue 24
	)
)

(instance twentyFive of MugginsInputItem
	(properties
		loop 6
		cel 4
		nsLeft 7
		nsTop 87
		normalCel 4
		hiCel 5
		returnValue 25
	)
)

(instance twentySix of MugginsInputItem
	(properties
		loop 7
		cel 4
		nsLeft 23
		nsTop 87
		normalCel 4
		hiCel 5
		returnValue 26
	)
)

(instance twentySeven of MugginsInputItem
	(properties
		loop 8
		cel 4
		nsLeft 39
		nsTop 87
		normalCel 4
		hiCel 5
		returnValue 27
	)
)

(instance twentyEight of MugginsInputItem
	(properties
		loop 9
		cel 4
		nsLeft 55
		nsTop 87
		normalCel 4
		hiCel 5
		returnValue 28
	)
)

(instance twentyNine of MugginsInputItem
	(properties
		loop 10
		cel 4
		nsLeft 71
		nsTop 87
		normalCel 4
		hiCel 5
		returnValue 29
	)
)

