;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Inset)
(use Feature)
(use User)
(use Actor)
(use System)

(public
	inNotebook 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(backPage hide:)
	(morePage hide:)
	(DrawPic 851)
	(notebookList eachElementDo: #subject 0)
	(Display {} dsRESTOREPIXELS local7)
	(= local7
		(Display
			@global136
			dsCOORD
			(- 160 (* 7 (StrLen @global136)))
			170
			dsFONT
			global119
			dsCOLOR
			global157
			dsSAVEPIXELS
		)
	)
	(for
		((= local2 (= temp0 (* (- local0 1) 8))))
		(and
			(< local2 (+ 8 temp0))
			(= temp1 (Memory memPEEK (+ local1 (* 2 local2))))
		)
		((++ local2))
		
		(= temp2 (notebookList at: (mod local2 8)))
		(if (temp2 respondsTo: #subject)
			(temp2 display: (mod local2 8) temp1)
		)
	)
	(if (and (== (mod local2 8) 0) (Memory memPEEK (+ local1 (* 2 local2))))
		(morePage show:)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(1
			(peopleTab show: (if (> (peopleTab x:) 100) 1 else 0))
			(= local1 @global202)
		)
		(2
			(placesTab show: (if (> (placesTab x:) 100) 1 else 0))
			(= local1 @global220)
		)
		(3
			(thingsTab show: (if (> (thingsTab x:) 100) 1 else 0))
			(= local1 @global228)
		)
		(4
			(miscTab show: (if (> (miscTab x:) 100) 1 else 0))
			(= local1 @global263)
		)
	)
	(titlePage hide:)
	(= local0 1)
	(localproc_0)
)

(class NotebookItem of Obj
	(properties
		subject 0
		x 0
		y 0
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
	)

	(method (init)
		(notebookList add: self)
		(super init:)
	)

	(method (display param1 param2 &tmp temp0 temp1 [temp2 40] temp42 temp43 temp44 temp45)
		(if (> param2 1088)
			(= temp45 (- param2 1088))
			(= temp42 857)
			(= temp43 (/ (- temp45 1) 16))
			(= temp44 (mod (- temp45 1) 16))
			(= subject (- param2 1024))
			(self posn: param1 temp42 temp43 temp44)
			(DrawCel temp42 temp43 temp44 x y)
		else
			(= subject param2)
			(= temp0 (/ subject 256))
			(= temp1 (mod subject 256))
			(self posn: param1)
			(Message msgGET 20 temp0 1 0 temp1 @temp2)
			(Display
				@temp2
				dsFONT
				10
				dsCOORD
				x
				y
				dsCOLOR
				(and (== local4 param2) global160)
				dsWIDTH
				100
			)
		)
	)

	(method (posn param1 param2 param3 param4 &tmp temp0)
		(if (< subject 256)
			(= temp0 (if (< param1 4) 65 else 172))
			(= nsTop (+ (* (mod param1 4) 24) 43))
			(= nsLeft (+ temp0 (if (mod param1 2) 45 else 0)))
			(= nsBottom (+ (CelHigh param2 param3 param4) nsTop))
			(= nsRight (+ (CelWide param2 param3 param4) nsLeft))
			(= x nsLeft)
			(= y nsTop)
		else
			(= nsTop (+ (* (mod param1 4) 24) 43))
			(= nsLeft (if (< param1 4) 65 else 182))
			(= nsBottom (+ 5 nsTop))
			(= nsRight (+ 78 nsLeft))
			(= x nsLeft)
			(= y nsTop)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evVERB) (self onMe: event))
				(event claimed: 1)
				(self doVerb: (event message:))
			)
		)
		(event claimed:)
	)

	(method (onMe param1)
		(return
			(if
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				1
			else
				0
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 100] temp100 temp101)
		(switch theVerb
			(13 ; Exit Icon
				(inNotebook doVerb: 13)
			)
			(4 ; Do
				(if (< subject 256)
					(= local4 0)
					(if (< (StrLen @global136) 16)
						(Format @global136 {%s%c} @global136 subject)
						(Display {} dsRESTOREPIXELS local7)
						(= local7
							(Display
								@global136
								dsCOORD
								(- 160 (* 7 (StrLen @global136)))
								170
								dsFONT
								global119
								dsCOLOR
								global157
								dsSAVEPIXELS
							)
						)
					)
				else
					(Display {} dsRESTOREPIXELS local7)
					(= global136 0)
					(= temp100 (/ local4 256))
					(= temp101 (mod local4 256))
					(if
						(and
							local4
							(notebookList
								firstTrue: #perform oldOnePresent local4
							)
						)
						(Message msgGET 20 temp100 1 0 temp101 @temp0)
						(Display @temp0 dsFONT 10 dsCOORD local5 local6 dsWIDTH 100)
					)
					(= local4 subject)
					(= local5 x)
					(= local6 y)
					(= temp100 (/ local4 256))
					(= temp101 (mod local4 256))
					(Message msgGET 20 temp100 1 0 temp101 @temp0)
					(Display
						@temp0
						dsFONT
						10
						dsCOORD
						local5
						local6
						dsCOLOR
						global160
						dsWIDTH
						100
					)
				)
			)
		)
	)
)

(instance oldOnePresent of Code
	(properties)

	(method (doit param1 param2)
		(return (== (param1 subject:) param2))
	)
)

(instance notebookList of EventHandler
	(properties)
)

(instance titlePage of View
	(properties
		x 156
		y 151
		modNum 20
		view 854
	)

	(method (initialize))

	(method (doVerb)
		(inNotebook doVerb: &rest)
	)
)

(instance morePage of View
	(properties
		x 237
		y 153
		modNum 20
		view 851
		loop 4
		cel 1
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(++ local0)
				(localproc_0)
				(backPage show:)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)
)

(instance backPage of View
	(properties
		x 85
		y 153
		modNum 20
		view 851
		loop 4
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(-- local0)
				(localproc_0)
				(if (== local0 1)
					(self hide:)
				else
					(self show:)
				)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)
)

(instance peopleTab of View
	(properties
		x 262
		y 58
		modNum 20
		view 851
		loop 1
		priority 5
		signal 16
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_1 1)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
		else
			(placesTab setLoop: 1 x: 262)
			(thingsTab setLoop: 1 x: 262)
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance placesTab of View
	(properties
		x 262
		y 92
		modNum 20
		view 851
		loop 1
		cel 1
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_1 2)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(peopleTab show: 1)
		else
			(thingsTab setLoop: 1 x: 262)
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance thingsTab of View
	(properties
		x 262
		y 128
		modNum 20
		view 851
		loop 1
		cel 2
		priority 4
		signal 16
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_1 3)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(placesTab show: 1)
		else
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance miscTab of View
	(properties
		x 262
		y 153
		modNum 20
		view 851
		loop 1
		cel 3
		priority 3
		signal 16
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_1 4)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(thingsTab show: 1)
		)
	)
)

(instance backUp of Feature
	(properties
		x 1
		y 1
		nsTop 175
		nsLeft 41
		nsBottom 189
		nsRight 279
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(StrAt @global136 (- (StrLen @global136) 1) 0)
				(Display {} dsRESTOREPIXELS local7)
				(= local7
					(Display
						@global136
						dsCOORD
						(- 160 (* 7 (StrLen @global136)))
						170
						dsFONT
						global119
						dsCOLOR
						global157
						dsSAVEPIXELS
					)
				)
			)
			(else
				(inNotebook doVerb: theVerb)
			)
		)
	)
)

(instance inNotebook of Inset
	(properties
		picture 851
		modNum 20
	)

	(method (init)
		(if (= local9 (!= (((gTheIconBar at: 0) cursor:) view:) 6))
			(proc0_8 1)
		)
		(gGame handsOff:)
		(gTheIconBar disable: 7 enable: 2 0)
		(super init: &rest)
		(= local8 0)
		(= global136 0)
		(for ((= local2 0)) (< local2 8) ((++ local2))
			((NotebookItem new:) posn: local2 init:)
		)
		(backUp init:)
		(titlePage init: stopUpd:)
		(morePage init: hide:)
		(backPage init: hide:)
		(peopleTab init: stopUpd:)
		(placesTab init: stopUpd:)
		(thingsTab init: stopUpd:)
		(miscTab init: stopUpd:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheIconBar select: (gTheIconBar at: 2))
		(gGame setCursor: 2)
		(self doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gGame setCursor: gWaitCursor)
				(if (not local4)
					(= local4 -1)
				)
				(= local8 local4)
				(inNotebook dispose:)
			)
		)
	)

	(method (doit &tmp temp0)
		(gPMouse joyInc: 2)
		(while (not local8)
			(Animate (gCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: #motionCue)
			)
			(if script
				(script doit:)
			)
			(= gLastEvent (= temp0 (Event new:)))
			(temp0 localize:)
			(if (and gPMouse (gTheDoits contains: gPMouse))
				(gPMouse doit:)
			)
			(gUser canControl: 1)
			(MapKeyToDir temp0)
			(if (== (temp0 type:) evJOYDOWN)
				(temp0
					type: evKEYBOARD
					message: (if (& (temp0 modifiers:) emSHIFT) 27 else 13)
					modifiers: $0000
				)
			)
			(if (& (temp0 type:) $0040) ; direction
				(if (and (== (temp0 message:) JOY_NULL) (& (temp0 type:) evKEYBOARD))
					(gTheIconBar handleEvent: temp0)
				else
					(gPMouse handleEvent: temp0)
				)
			else
				(gTheIconBar handleEvent: temp0)
				(if (& (temp0 type:) evVERB)
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY temp0)
					(gFeatures eachElementDo: #perform OnMeAndLowY temp0)
					(cond
						((notebookList handleEvent: temp0))
						((OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: temp0)
						)
					)
				)
			)
			(temp0 dispose:)
		)
		(gPMouse joyInc: 5)
		(return local8)
	)

	(method (dispose)
		(notebookList dispose:)
		(super dispose: &rest)
		(Animate (gCast elements:) 0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if local9
			(proc0_8 0)
		)
		(gGame handsOn: 1)
		(gTheIconBar enable: 7)
		(DisposeScript 20)
	)
)

