;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)

(class Button of Prop
	(properties
		active 1
		allowModifiers 0
		upView -1
		upLoop -1
		upCel 0
		downView -1
		downLoop -1
		downCel 1
		useRect 0
		keyMessage -1
		doVerbCalled 0
	)

	(method (init)
		(if (== upView -1)
			(= upView view)
		)
		(if (== upLoop -1)
			(= upLoop loop)
		)
		(if (== downView -1)
			(= downView view)
		)
		(if (== downLoop -1)
			(= downLoop loop)
		)
		(if active
			(self view: upView loop: upLoop cel: upCel)
		else
			(self view: downView loop: downLoop cel: downCel)
		)
		(super init: &rest)
		(if (!= keyMessage -1)
			(gDirectionHandler add: self)
			(gKeyDownHandler add: self)
		)
		(if (== plane gThePlane)
			(gMouseDownHandler addToFront: self)
		)
		(gTheHotspotList add: self)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (not (= temp0 (super onMe: param1))) useRect)
			(= temp0
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(if (or (not active) (event claimed:))
			(return)
		)
		(if
			(or
				(and (& (event type:) evMOUSE) (not (self onMe: event)))
				(not (event type:))
				(not (gUser input:))
				(and (not allowModifiers) (event modifiers:))
			)
			(super handleEvent: event)
			(return)
		)
		(if (& (event type:) $0014) ; direction | evKEYBOARD
			(if (and (!= keyMessage -1) (== keyMessage (event message:)))
				(self doVerb: 29)
				(event claimed: 1)
			)
			(event claimed:)
			(return)
		)
		(if (& (event type:) evMOUSEBUTTON)
			(self trace: event)
		)
		(event claimed:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp7 0)
		(= temp6 (= temp8 0))
		(while 1
			(= temp5 temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent evMOUSE param1)
			(param1 localize: plane)
			(if (& (param1 type:) $0002)
				(break)
			else
				(= temp2 view)
				(= temp3 loop)
				(= temp4 cel)
				(if (self onMe: param1)
					(self view: downView loop: downLoop cel: downCel)
					(= temp1 1)
					(if
						(and
							doVerbCalled
							(or
								(not temp8)
								(and
									(< temp6 60)
									(= temp6 (Abs (- temp8 gGameTime)))
									0
								)
								(and (>= temp6 60) (<= (-- temp7) 0))
							)
						)
						(= temp8 gGameTime)
						(= temp7 20)
						(self doVerb: 29)
					)
				else
					(self view: upView loop: upLoop cel: upCel)
					(= temp1 0)
				)
			)
			(if (or (!= temp2 view) (!= temp3 loop) (!= temp4 cel))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (!= temp5 temp1)
				(= temp5 temp1)
				(if temp1
					(buttonSound number: 1 loop: 1 play:)
					(continue)
				)
			else
				(continue)
			)
			(buttonSound number: 2 loop: 1 play:)
		)
		(if active
			(self view: upView loop: upLoop cel: upCel)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(buttonSound number: 2 loop: 1 play:)
		(if (and temp1 (not doVerbCalled))
			(self doVerb: 29)
		)
		(param1 claimed: 1)
	)

	(method (doVerb)
		(if (buttonSound handle:)
			(buttonSound stop:)
		)
		(if code
			(code doit:)
		)
	)

	(method (dispose)
		(if (!= keyMessage -1)
			(gDirectionHandler delete: self)
			(gKeyDownHandler delete: self)
		)
		(if (== plane gThePlane)
			(gMouseDownHandler delete: self)
		)
		(buttonSound stop: dispose:)
		(gTheHotspotList delete: self)
		(super dispose: &rest)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self view: upView loop: upLoop cel: upCel active: 1)
		else
			(self view: downView loop: downLoop cel: downCel active: 0)
		)
		(UpdateScreenItem self)
	)

	(method (checkEvent param1 &tmp temp0 temp1)
		(= temp1 (param1 plane:))
		(param1 localize: plane)
		(= temp0
			(if active
				(self onMe: param1)
			)
		)
		(if temp1
			(param1 localize: temp1)
		else
			(param1 globalize:)
		)
		(return temp0)
	)

	(method (setCursor param1)
		(if param1
			(gTheHotspotCursor view: 999 loop: 0 cel: 0)
		)
		(gSwatInterface setCursor:)
	)
)

(instance buttonSound of Sound
	(properties
		flags 5
	)
)

