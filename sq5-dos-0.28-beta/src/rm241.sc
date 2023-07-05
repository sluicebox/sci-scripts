;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 241)
(include sci.sh)
(use Main)
(use keyStuff_242)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rm241 0
	proc241_1 1
	proc241_2 2
	proc241_3 3
	proc241_4 4
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc241_4 param1)
	(PalVary pvUNINIT)
	(PalVary pvINIT param1 5)
)

(procedure (proc241_1 param1)
	(= local0 param1)
	(= local3 param1)
	(switch local2
		(0
			(if (or (!= local3 10) (== global164 1))
				(if (== global164 1)
					(= global164 6)
				else
					(= global164 3)
				)
			else
				(= global164 1)
			)
		)
		(2
			(if (or (!= local3 10) (!= global164 1))
				(if (OneOf global164 0 2)
					(= global164 5)
				else
					(= global164 4)
				)
			else
				(= global164 2)
			)
		)
		(else
			(= global164 7)
		)
	)
	(gCurRoom setScript: countDownClock)
)

(procedure (proc241_2 param1)
	(if argc
		(= local2 param1)
	)
	(return local2)
)

(procedure (proc241_3 param1)
	(if argc
		(= local0 param1)
	)
	(return local0)
)

(instance rm241 of Rm
	(properties
		noun 1
		picture 47
		style -32761
	)

	(method (doVerb theVerb)
		(cond
			((not (InRect 53 16 258 168 gMouseX gMouseY))
				(if (!= script countDownClock)
					(gSq5Music1 stop:)
					(self newRoom: 240)
				)
			)
			((== theVerb 1) ; Look
				(gMessager
					say:
						noun
						1
						(switch global164
							(0 11)
							(1 10)
							(8 9)
							(2 12)
						)
						0
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(if (== global164 1)
			(Palette palSET_FROM_RESOURCE 471 2)
			(PalVary pvINIT 471 0)
		)
		(if (<= global164 8)
			(face init: stopUpd:)
		)
		(chamberControls init: setOnMeCheck: 1 2)
		(topControlf init: setOnMeCheck: 1 16)
		(chamberf init: setOnMeCheck: 1 32)
		(self setScript: startAll)
	)

	(method (doit)
		(if (and (GameIsRestarting) (== global164 1))
			(Palette palSET_FROM_RESOURCE 471 2)
			(PalVary pvINIT 471 0)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gSq5Music1 fade: 0 10 5 1)
		(PalVary pvUNINIT)
		(DisposeScript 242)
		(super dispose: &rest)
	)
)

(instance face of Prop
	(properties
		x 122
		y 49
		view 263
		signal 16384
	)

	(method (init)
		(if (< global118 3)
			(self setCel: global118)
			(++ global118)
		else
			(self setCel: 3)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom doVerb: &rest)
	)
)

(instance chamberControls of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(face setScript: useChamberControls)
			)
			(1 ; Look
				(face setScript: useChamberControls)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance startAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 101 loop: -1 play:)
				(= cycles 1)
			)
			(1
				(if (== global164 1)
					(Palette palSET_FROM_RESOURCE 471 2)
				)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

(instance useChamberControls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(self setScript: (ScriptID 242 0) self local0) ; keyStuff
			)
			(1
				(gGame handsOn:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance countDownClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 225 loop: -1 play:)
				(= cycles 1)
			)
			(1
				(= ticks 50)
			)
			(2
				(= next endActionsScript)
				(-- local0)
				(if local1
					(proc242_1)
				)
				(cond
					((not (OneOf global164 1 2))
						(if (or (not local0) (> (- local3 local0) 5))
							(self dispose:)
						else
							(-= state 2)
							(= cycles 1)
						)
					)
					((not local0)
						(self dispose:)
					)
					(else
						(-= state 2)
						(= cycles 1)
					)
				)
			)
		)
	)
)

(instance endActionsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 241 loop: 1 play:)
				(if local1
					((ScriptID 242 0) caller: self cue:) ; keyStuff
				else
					(= cycles 2)
				)
			)
			(1
				(switch global164
					(0
						(= register 8)
					)
					(1
						(SetScore 186 75)
						(= register 4)
					)
					(2
						(if (and (== global113 8) (& global169 $0002))
							(SetScore 187 50)
							(= register 1)
						else
							(= register 13)
						)
					)
					(3
						(= register 5)
					)
					(4
						(= register 2)
					)
					(5
						(= register 6)
					)
					(6
						(= register 3)
					)
					(7
						(= register 7)
					)
				)
				(gMessager say: 1 0 register 0 self)
			)
			(2
				(if (OneOf register 4 1)
					(if (== register 1)
						(gSq5Music1 number: 225 loop: -1 play:)
						(proc241_4 47)
						(= seconds 5)
					else
						(gSq5Music1 stop:)
						(gCurRoom newRoom: 240)
					)
				else
					(gSq5Music1 stop:)
					(EgoDead 46) ; "Bea is dead. In an alternate future she would've bourne your son. In the future past of Space Quest 4 your son would've saved your life from the time rippers. But she didn't so he couldn't, therefore you aren't."
				)
			)
			(3
				(gSq5Music1 stop:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance topControlf of Feature
	(properties
		noun 3
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager
				say:
					noun
					1
					(switch global164
						(0 11)
						(1 10)
						(8 9)
						(2 12)
					)
					0
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chamberf of Feature
	(properties
		noun 4
		onMeCheck 32
	)
)

