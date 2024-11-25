;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)

(class KeyPadButn of View
	(properties
		myValue 0
		downView -1
		downLoop -1
		downCel -1
		upView -1
		upLoop -1
		upCel -1
	)

	(method (init)
		(if (== downView -1)
			(= downView view)
		)
		(if (== downLoop -1)
			(= downLoop loop)
		)
		(if (== downCel -1)
			(= downCel cel)
		)
		(if (== upView -1)
			(= upView view)
		)
		(if (== upLoop -1)
			(= upLoop loop)
		)
		(if (== upCel -1)
			(= upCel cel)
		)
		(self setPri: 300)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(= temp0 (event plane:))
		(event localize: global116)
		(if
			(and
				(not (event type:))
				scratch
				(self onMe: event)
				(scratch respondsTo: (gTheCursor verb:))
			)
			(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			(event claimed: 1)
		)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(self trace: event)
		)
		(if temp0
			(event localize: temp0)
		else
			(event globalize:)
		)
		(event claimed:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 0)
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
			)
		)
		(self view: upView loop: upLoop cel: upCel)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(controlSound number: 6102 loop: 1 play:)
			(self doVerb: 2)
		)
		(param1 claimed: 1)
	)

	(method (doVerb))
)

(instance controlSound of Sound
	(properties
		flags 5
		number 6102
	)
)

