;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	restartCode 0
)

(local
	[local0 2]
	local2
	local3 = 1
	local4
	local5
)

(instance restartCode of Code
	(properties)

	(method (doit param1)
		(gTheIconBar disable:)
		(= local4 (gTheCursor cel:))
		(gGame setCursor: 999)
		(= local5 (gUser input:))
		(gUser canInput: 1)
		(genericPanel init: param1)
	)
)

(instance genericPanel of View
	(properties)

	(method (init param1)
		(self setPri: 15)
		(= view (+ 992 param1))
		(= x (/ (- 320 (CelWide view loop cel)) 2))
		(= y (/ (- 200 (CelHigh view loop cel)) 2))
		(if (== param1 1)
			(= view 993)
			(= [local0 0] (restartBut init: yourself:))
			(= [local0 1] (playBut init: yourself:))
		else
			(= view 992)
			(= [local0 0] (quitBut init: yourself:))
			(= [local0 1] (whoopsBut init: yourself:))
		)
		(super init:)
		(highlighter init:)
		(SetCursor
			(+
				(/ (- ([local0 local2] nsRight:) ([local0 local2] nsLeft:)) 2)
				([local0 local2] nsLeft:)
			)
			([local0 local2] nsBottom:)
		)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(self doit:)
	)

	(method (doit &tmp temp0)
		(while (== local3 1)
			(= temp0 (Event new:))
			(temp0 localize:)
			(self handleEvent: temp0)
			([local0 0] handleEvent: temp0)
			([local0 1] handleEvent: temp0)
			(temp0 dispose:)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or (& (event type:) evKEYBOARD) (& (event type:) $0040)) ; direction
				(OneOf
					(event message:)
					KEY_TAB
					KEY_SHIFTTAB
					KEY_UP
					KEY_DOWN
					KEY_LEFT
					KEY_RIGHT
					JOY_UP
					JOY_RIGHT
					JOY_DOWN
					JOY_LEFT
				)
			)
			(= local2 (if local2 0 else 1))
			(SetCursor
				(+
					(/
						(- ([local0 local2] nsRight:) ([local0 local2] nsLeft:))
						2
					)
					([local0 local2] nsLeft:)
				)
				([local0 local2] nsBottom:)
			)
			(event claimed: 1)
			(return)
		)
	)

	(method (dispose)
		([local0 0] dispose:)
		([local0 1] dispose:)
		(highlighter dispose:)
		(gTheIconBar enable:)
		(gUser canInput: local5)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
		(Animate (gCast elements:) 0)
		(gGame setCursor: local4)
		(DisposeScript 17)
	)
)

(instance highlighter of View
	(properties
		view 992
		loop 1
	)

	(method (init)
		(self setPri: 15)
		(super init:)
		(self hide:)
	)

	(method (show param1)
		(= x (param1 hiX:))
		(= y (genericPanel nsBottom:))
		(= z (- (genericPanel nsBottom:) (param1 hiY:)))
		(= view (param1 hiView:))
		(= loop (param1 hiLoop:))
		(= cel (param1 hiCel:))
		(super show:)
		(Animate (gCast elements:) 0)
	)

	(method (hide)
		(super hide:)
		(Animate (gCast elements:) 0)
	)
)

(class PanelButton of Feature
	(properties
		y 200
		hiX 0
		hiY 0
		hiView 0
		hiLoop 0
		hiCel 0
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp0 (event type:))
		(cond
			((event claimed:)
				(return 1)
			)
			((self onMe: event)
				(if (& temp0 evMOUSEBUTTON)
					(repeat
						(= temp2 (Event new:))
						(temp2 localize:)
						(cond
							((self onMe: temp2)
								(if (& (highlighter signal:) $0088)
									(highlighter show: self)
								)
							)
							((not (& (highlighter signal:) $0088))
								(highlighter hide:)
							)
						)
						(= temp1 (& (temp2 type:) evMOUSERELEASE))
						(temp2 dispose:)
						(breakif temp1)
					)
					(if (IsObject temp2)
						(temp2 dispose:)
					)
					(if (not (& (highlighter signal:) $0008))
						(highlighter hide:)
						(self doVerb:)
						(return 0)
					else
						(highlighter hide:)
						(event claimed: 1)
					)
				else
					(if (== temp0 evJOYDOWN)
						(event
							type: evKEYBOARD
							message:
								(if (& (event modifiers:) emSHIFT) 27 else 13)
							modifiers: $0000
						)
					)
					(if (and (& evKEYBOARD (event type:)) (== (event message:) KEY_RETURN))
						(highlighter show: self)
						(highlighter hide:)
						(self doVerb:)
						(event claimed: 1)
						(return)
					else
						(return 0)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance restartBut of PanelButton
	(properties)

	(method (init)
		(= nsLeft (+ (genericPanel x:) 17))
		(= nsTop (+ (genericPanel y:) 21))
		(= nsBottom (+ (genericPanel y:) 60))
		(= nsRight (+ (genericPanel x:) 94))
		(= hiX (+ (genericPanel x:) (proc0_13 24 24 19 24 24)))
		(= hiY (+ (genericPanel y:) (proc0_13 29 29 30 29 29 29)))
		(= hiView 993)
		(= hiLoop 1)
		(= hiCel 0)
	)

	(method (doVerb)
		(= local3 0)
		(Game restart:)
	)
)

(instance playBut of PanelButton
	(properties)

	(method (init)
		(= nsLeft (+ (genericPanel x:) 103))
		(= nsTop (+ (genericPanel y:) 21))
		(= nsBottom (+ (genericPanel y:) 60))
		(= nsRight (+ (genericPanel x:) 182))
		(= hiX (+ (genericPanel x:) (proc0_13 105 105 118 105 105)))
		(= hiY (+ (genericPanel y:) (proc0_13 36 36 29 36 36)))
		(= hiView 993)
		(= hiLoop 2)
		(= hiCel 0)
	)

	(method (doVerb)
		(= local3 0)
		(genericPanel dispose:)
	)
)

(instance quitBut of PanelButton
	(properties)

	(method (init)
		(= nsLeft (+ (genericPanel x:) 16))
		(= nsTop (+ (genericPanel y:) 21))
		(= nsBottom (+ (genericPanel y:) 38))
		(= nsRight (+ (genericPanel x:) 79))
		(= hiX (+ (genericPanel x:) (proc0_13 19 19 31 19 19)))
		(= hiY (+ (genericPanel y:) (proc0_13 26 26 27 26 26)))
		(= hiView 992)
		(= hiLoop 1)
		(= hiCel 0)
	)

	(method (doVerb)
		(= local3 0)
		(= gQuit 1)
	)
)

(instance whoopsBut of PanelButton
	(properties)

	(method (init)
		(= nsLeft (+ (genericPanel x:) 87))
		(= nsTop (+ (genericPanel y:) 21))
		(= nsBottom (+ (genericPanel y:) 38))
		(= nsRight (+ (genericPanel x:) 151))
		(= hiX (+ (genericPanel x:) (proc0_13 109 109 106 109 109)))
		(= hiY (+ (genericPanel y:) (proc0_13 26 26 27 26 26)))
		(= hiView 992)
		(= hiLoop 2)
		(= hiCel 0)
	)

	(method (doVerb)
		(= local3 0)
		(genericPanel dispose:)
	)
)

