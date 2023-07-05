;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use System)

(public
	rm590 0
)

(local
	local0
)

(instance rm590 of LarryRoom
	(properties
		noun 9
		picture 590
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (!= ((gInventory at: 17) owner:) gCurRoomNum) ; gown
					(if (IsFlag 38)
						(= local0 -1)
					)
					(gMessager
						say:
							noun
							theVerb
							(switch (++ local0)
								(1 4)
								(2 3)
								(3 7)
								(4 8)
								(5
									(gGame changeScore: 4 225)
									(SetFlag 38)
									9
								)
								(else 2)
							)
					)
				else
					(gMessager say: noun theVerb 1) ; "Well, Shablee. I guess I'll be leaving now. I'll look forward to our big date tonight, down at the beach!"
				)
				(return 1)
			)
			(18 ; gown
				(gCurRoom setScript: giveGownScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		((ScriptID 0 11) init: 580) ; iconExit
		(gGame handsOn:)
		(super init: &rest)
		(gNarrator x: 10 y: 10 talkWidth: 150)
		(shabArm init:)
		(shabChest init:)
		(shabEyes init:)
		(shabHair init:)
		(shabNose init:)
		(shabMouth init:)
		(if (== global173 18)
			(self doVerb: 18)
		else
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1 talkWidth: 0)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose: &rest)
	)
)

(instance showCondomScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 9 65 1 0 self) ; "Those ARE a good idea, aren't they? Later, if we get to know each other a little better, you should try this idea again!"
			)
			(1
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance giveGownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 14 226)
				(gEgo put: 17 gCurRoomNum) ; gown
				(gMessager say: 9 18 0 1 4 self) ; "Oh, Shablee! I hope you love this gown. I really think it's you!"
			)
			(2
				(if (gEgo has: 8) ; condom
					(gMessager say: 9 18 0 5 6 self oneOnly: 0) ; "I say: I'll be there!"
					0
					self
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gGame hideControls:)
				(SetPort 0 0 190 320 10 0)
				(DrawPic 98 6)
				(= ticks 180)
			)
			(5
				(gNarrator x: -1 y: -1 talkWidth: 0)
				(gMessager say: 9 18 0 7 self) ; "Later that night..."
			)
			(6
				(= ticks 120)
			)
			(7
				(SetFlag 24)
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance shabArm of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 212 107 228 99 244 107 250 139 212 139 209 123
					yourself:
				)
		)
	)
)

(instance shabChest of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 175 75 221 97 201 124 151 97 yourself:)
		)
	)
)

(instance shabEyes of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 183 40 212 37 212 49 195 48 184 53
					yourself:
				)
		)
	)
)

(instance shabHair of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 176 31 184 8 206 0 231 12 242 34 236 57 225 57 225 34 218 38 207 29 188 29 181 41
					yourself:
				)
		)
	)
)

(instance shabNose of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 203 48 202 57 191 58 191 50
					yourself:
				)
		)
	)
)

(instance shabMouth of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 190 60 204 58 205 67 194 68 yourself:)
		)
	)
)

