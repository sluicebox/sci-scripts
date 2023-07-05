;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use HRView)
(use GKIconbar)
(use n013)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Cursor)
(use Game)
(use Actor)
(use System)

(public
	rm302 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 2]
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
)

(procedure (localproc_0 param1 param2)
	(return
		(cond
			(param1
				(- (mod (- param2 65) 15) 1)
			)
			((and (/ (- param2 65) 15) (== (mod (- param2 65) 15) 0)) 15)
			((and (not (/ (- param2 65) 15)) (== (mod (- param2 65) 15) 0)) 0)
			(else
				(mod (- param2 65) 15)
			)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(return (if (<= (- param1 65) 15) 0 else 1))
)

(procedure (localproc_2)
	(selectRect hide:)
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(= temp0 (+ (/ param1 6) 1))
	(if (== (= temp1 (mod param1 6)) 0)
		(= temp1 6)
		(-- temp0)
	)
	(= local3 (- (+ (* (- temp1 1) 20) 3) 1))
	(= local4 (+ (* (- temp0 1) 24) 24))
	(selectRect posn: local3 local4 show:)
)

(procedure (localproc_4)
	(-- local10)
	((local8 at: local10) dispose:)
	(local9 at: local10 { })
	(if (> local18 1)
		(-- local18)
		(-= local16 20)
	else
		(= local18 7)
		(= local16 260)
		(-= local17 24)
	)
)

(instance rm302 of Room
	(properties
		modNum 301
		noun 1
		picture 305
		style 14
		exitStyle 13
	)

	(method (init)
		(= local8 (IDArray new: 35))
		(= local9 (Str new: 35))
		(= local11 (Str with: {XDJKEEPEYESONGKBUTDONOTHARM}))
		(= local12 (Str with: {XDJCONCLAVETONIGHTBRINGFWETKASH}))
		(= local13 (Str with: {DJBRINGSEKEYMADOULE}))
		(= local14 (Str with: {DJCONCLAVETONIGHTBRINGSEKEYMADOULE}))
		(gGkMusic1 setVol: 40)
		(= local15 local11)
		(= local7 (- (local15 size:) 1))
		(= local10 0)
		(= local16 140)
		(= local17 30)
		(= local18 1)
		(gGame handsOn:)
		(super init:)
		(= local1 gTheCursor)
		(GK setCursor: ((ScriptID 0 1) view: 999 yourself:)) ; globeCursor
		(if (gGame barUp:)
			(gTheIconBar erase:)
		)
		(= local0 gTheIconBar)
		(= gTheIconBar codeBar)
		(codeBar
			add:
				codeIcon3
				codeIcon0
				codeIcon1
				codeIcon2
				tomIcon5
				tomIcon11
				tomIcon12
				tomIcon13
			helpIconItem: tomIcon5
			init:
			state: 3072
		)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(selectRect init:)
		(messageView init:)
	)

	(method (dispose)
		(cond
			((local9 compare: local13)
				(SetFlag 394)
				(SetFlag 246)
			)
			((local9 compare: local14)
				(SetFlag 246)
			)
			(else
				(SetFlag 247)
			)
		)
		(if (not local10)
			(SetFlag 250)
		)
		(= gTheIconBar local0)
		(GK setCursor: local1)
		(codeBar dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local11 dispose:)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(>= gMouseX 3)
				(< gMouseX 123)
				(>= (- gMouseY 10) 22)
				(< (- gMouseY 10) 142)
			)
			(if (and (!= local2 (getButton doit:)) (<= local2 local7))
				(localproc_3 local2)
			)
		else
			(localproc_2)
			(= local2 1000)
		)
		(super doit:)
	)

	(method (doVerb)
		(return 1)
	)
)

(instance messageView of View
	(properties
		y 22
		view 3021
	)

	(method (doVerb)
		(if
			(and
				(>= gMouseX 3)
				(< gMouseX 123)
				(>= (- gMouseY 10) 22)
				(< (- gMouseY 10) 142)
				(<= local2 local7)
			)
			(if (<= local10 34)
				(gCurRoom setScript: selectChar)
			else
				(Printf {You have run out of room on the wall})
			)
		)
		(return 1)
	)
)

(instance selectRect of View
	(properties
		x -100
		view 3021
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance getButton of Code
	(properties)

	(method (doit)
		(= local2
			(+ (/ (- gMouseX 3) 20) 1 (* (/ (- (- gMouseY 10) 22) 24) 6))
		)
	)
)

(instance sChangePage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(localproc_2)
				(= cycles 1)
			)
			(2
				(if (== local15 local11)
					(= local15 local12)
					(messageView view: 3020 setCel: 0 setLoop: 0)
				else
					(= local15 local11)
					(messageView view: 3021 setCel: 0 setLoop: 0)
				)
				(= local7 (- (local15 size:) 1))
				(= cycles 1)
			)
			(3
				(if
					(and
						(>= gMouseX 3)
						(< gMouseX 123)
						(>= (- gMouseY 10) 22)
						(< (- gMouseY 10) 142)
					)
					(localproc_3 local2)
				)
				(self dispose:)
			)
		)
	)
)

(instance selectChar of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 1)
			)
			(1
				(= temp0 (localproc_1 (local15 at: local2)))
				(= temp1 (localproc_0 temp0 (local15 at: local2)))
				(local8 at: local10 (charView new:))
				(local9 at: local10 (local15 at: local2))
				((local8 at: local10)
					view: 310
					posn: local16 local17
					loop: (+ temp0 2)
					cel: temp1
					init:
				)
				(++ local10)
				(if (> (++ local18) 7)
					(= local18 1)
					(= local16 140)
					(+= local17 24)
				else
					(+= local16 20)
				)
				(= local2 1000)
				(self dispose:)
			)
		)
	)
)

(instance charView of View
	(properties)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(class codeBar of GKIconbar
	(properties)

	(method (init)
		(= plane tomBarPlane)
		(plane back: 0 priority: -1 init: 0 0 210 100 addCast: self)
		(self eachElementDo: #init self)
		(plane setSize:)
		(= local19 (Cast new:))
		(plane addCast: local19)
		(cLion1 init: local19)
		(cBar1 init: local19)
		(cBorder init: local19)
		(cBar2 init: local19)
		(cBar3 init: local19)
		(cBar4 init: local19)
		(cBar5 init: local19)
		(cBar6 init: local19)
		(cLion2 init: local19)
		(cLion1Eyes init: local19)
		(cLion2Eyes init: local19)
		(cInvIcon init: local19)
		(cScore init: local19)
		(eOne init: local19)
		(eTwo init: local19)
		(eThree init: local19)
		(eFour init: local19)
		(eFive init: local19 hide:)
		(eSix init: local19 hide:)
		(plane setSize:)
		(self curInvIcon: 0 curIcon: codeIcon0 state: 3072 updateScore:)
	)

	(method (show)
		(localproc_2)
		(super show: &rest)
	)

	(method (hide &tmp temp0)
		(= temp0 (gGame keepBar:))
		(gGame keepBar: 0)
		(super hide: &rest)
		(gGame keepBar: temp0)
	)

	(method (drawScore)
		(cond
			((< gScore 10)
				(eFour setLoop: 4 cel: gScore posn: 233 3)
				(UpdateScreenItem eFour)
			)
			((< gScore 100)
				(eFour setLoop: 4 cel: (/ gScore 10) posn: 231 3)
				(UpdateScreenItem eFour)
				(eFive setLoop: 4 cel: (mod gScore 10) posn: 237 3 show:)
				(UpdateScreenItem eFive)
			)
			(else
				(eFour setLoop: 4 cel: (/ gScore 100) posn: 227 3)
				(UpdateScreenItem eFour)
				(eFive
					setLoop: 4
					cel: (/ (mod gScore 100) 10)
					posn: 233 3
					show:
				)
				(UpdateScreenItem eFive)
				(eSix setLoop: 4 cel: (mod gScore 10) posn: 239 3 show:)
				(UpdateScreenItem eSix)
			)
		)
	)
)

(instance codeIcon0 of GKIconItem
	(properties
		noun 35
		x 46
		y 2
		signal 3
		message 0
		mainView 956
		maskView 956
		maskCel 1
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (> local10 0)
				(localproc_4)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance codeIcon6 of GKIconItem ; UNUSED
	(properties
		x 117
		y 3
		signal 65
		message 7
		mainView 960
		mainLoop 5
		maskView 960
		maskLoop 5
		maskCel 2
		helpVerb 68
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance codeIcon1 of GKIconItem
	(properties
		noun 36
		x 92
		y 2
		signal 67
		message 0
		mainView 956
		mainLoop 1
		maskView 956
		maskLoop 1
		maskCel 1
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gCurRoom setScript: sChangePage)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance codeIcon2 of GKIconItem
	(properties
		noun 37
		x 144
		signal 67
		message 0
		mainView 956
		mainLoop 2
		maskView 956
		maskLoop 2
		maskCel 1
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gCurRoom newRoom: 300)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance codeIcon3 of GKIconItem
	(properties
		x 299
		message 0
		mainView 956
		mainLoop 2
		maskView 956
		maskLoop 2
		maskCel 1
		cursorView 999
		cursorLoop 0
		cursorCel 0
	)

	(method (select)
		(return 0)
	)

	(method (highlight))

	(method (show))

	(method (mask))
)

(instance tomIcon5 of GKIconItem
	(properties
		noun 1
		x 254
		signal 3
		type 8192
		message 68
		mainView 960
		mainLoop 10
		maskView 960
		maskLoop 10
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: theHelpCursor)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)
)

(instance tomIcon11 of GKIconItem
	(properties
		noun 14
		x 254
		y 16
		signal 71
		message 0
		mainView 960
		mainLoop 11
		mainCel 1
		maskView 960
		maskLoop 11
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(return 0)
	)
)

(instance tomIcon12 of GKIconItem
	(properties
		x 172
		signal 65
		message 0
		mainView 959
		mainLoop 2
		maskView 959
		maskLoop 2
		maskCel 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
	)
)

(instance tomIcon13 of GKIconItem
	(properties
		x 223
		signal 4
		mainView 959
		mainLoop 3
	)

	(method (mask))
)

(instance cScore of HRView
	(properties
		x 224
		view 959
		loop 3
	)
)

(instance eOne of HRView
	(properties
		x 227
		y 20
		view 959
		loop 4
		cel 3
	)
)

(instance eTwo of HRView
	(properties
		x 233
		y 20
		view 959
		loop 4
		cel 4
	)
)

(instance eThree of HRView
	(properties
		x 239
		y 20
		view 959
		loop 4
	)
)

(instance eFour of HRView
	(properties
		x 233
		y 3
		view 959
		loop 4
	)
)

(instance eFive of HRView
	(properties
		view 959
		loop 4
	)
)

(instance eSix of HRView
	(properties
		view 959
		loop 4
	)
)

(instance cLion1 of HRView
	(properties
		view 959
		loop 1
		cel 2
	)
)

(instance cBar1 of HRView
	(properties
		x 37
		view 959
		loop 1
	)
)

(instance cBorder of HRView
	(properties
		x 43
		view 959
		loop 5
	)
)

(instance cBar2 of HRView
	(properties
		x 138
		view 959
		loop 1
	)
)

(instance cBar3 of HRView
	(properties
		x 167
		view 959
		loop 1
	)
)

(instance cBar4 of HRView
	(properties
		x 218
		view 959
		loop 1
	)
)

(instance cBar5 of HRView
	(properties
		x 248
		view 959
		loop 1
	)
)

(instance cBar6 of HRView
	(properties
		x 277
		view 959
		loop 1
	)
)

(instance cLion2 of HRView
	(properties
		x 283
		view 959
		loop 1
		cel 1
	)
)

(instance cLion1Eyes of HRView
	(properties
		x 8
		y 8
		view 959
		loop 8
	)
)

(instance cLion2Eyes of HRView
	(properties
		x 292
		y 8
		view 959
		loop 7
	)
)

(instance cInvIcon of HRView
	(properties
		x 173
		view 959
		loop 2
		cel 2
	)
)

(instance tomBarPlane of Plane
	(properties)
)

(instance theHelpCursor of Cursor
	(properties
		view 958
		loop 8
	)
)

