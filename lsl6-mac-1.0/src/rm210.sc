;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use Timer)
(use System)

(public
	rm210 0
)

(local
	local0
	local1
	local2 = -1
)

(instance rm210 of LarryRoom
	(properties
		noun 4
		picture 210
		horizon 0
	)

	(method (init)
		(super init: &rest)
		(if (and (not (gGlobalSound2 handle:)) (!= gPrevRoomNum 200))
			(gGlobalSound2 number: 200 loop: -1 play:)
		)
		(UnLoad 128 80)
		(theEyes init:)
		(lArm init:)
		(rArm init:)
		(hair init:)
		(lips init:)
		(breasts init:)
		(hands init:)
		((ScriptID 0 11) init: 200) ; iconExit
		(gGame handsOff:)
		(if (and (not (IsFlag 20)) (IsFlag 183))
			(self setScript: happyGammieScr)
		else
			(talkTimer setCycle: talkTimer 2)
		)
		(Load rsSCRIPT 1800)
		(Load rsSCRIPT 1801)
		(= local2 (gNarrator talkWidth:))
		(gNarrator x: 5 y: 10 talkWidth: 130)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((IsFlag 183)
					(self setScript: happyGammieScr)
				)
				((IsFlag 21)
					(gMessager say: 4 2 12) ; "I'll do my best to fix that machine for you, Gammie. You can count on me... at least somewhat."
					(return 1)
				)
				(else
					(switch (++ local0)
						(1
							(if (gEgo has: 22) ; roomkey
								(++ local0)
								(gCurRoom doVerb: theVerb)
							else
								(gMessager say: 4 2 5) ; "Good day, Miss. My name is Larry; Larry Laffer. I'm here as the guest of "Stallions," that famous television show."
							)
						)
						(2
							(gCurRoom setScript: giveLarryHisKey 0 0)
						)
						(3
							(gMessager say: 4 2 7) ; "Say, baby... what time do you get off?"
						)
						(4
							(gMessager say: 4 2 8) ; "How about we get together later? What do you say?"
						)
						(5
							(gMessager say: 4 2 9) ; "Just work and exercise? What a waste!"
						)
						(6
							(gMessager say: 4 2 10) ; "Dr. Swineheart, did you say? Who's he?"
						)
						(7
							(gCurRoom setScript: tellLarryAboutMachine)
						)
					)
					(return 1)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gNarrator x: -1 y: -1 talkWidth: local2)
		(gGlobalSound2 fade: 127 10 10 0)
		(talkTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance theEyes of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 151 31 181 31 181 44 151 44
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 2 6)) ; Talk, Zipper
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance rArm of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 112 108 115 86 129 78 137 80 144 103 135 108 122 135 147 135 147 139 98 139
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 2 6)) ; Talk, Zipper
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance lArm of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 192 66 203 71 206 81 198 95
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 2 6)) ; Talk, Zipper
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance hair of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 131 55 134 33 148 17 148 11 153 5 176 5 189 13 192 43 199 53 200 66 190 73 178 69 178 56 181 53 180 32 167 27 151 33 148 45 153 49 154 69 144 80 132 77
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Talk
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance hands of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 159 128 175 124 193 124 201 120 205 130 202 139 146 139 146 135
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 2 6)) ; Talk, Zipper
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance breasts of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 135 111 157 97 176 107 184 95 198 95 209 103 207 117 194 124 172 125 151 134 146 136 141 133
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (++ local1)
					(1
						(gMessager say: 2 1 1) ; "You seem to be unable to look anywhere else!"
					)
					(2
						(gMessager say: 2 1 2) ; "Your breath catches in your throat as you gaze at Gammie's taut yet ample gifts."
					)
					(else
						(gMessager say: 2 1 3) ; "Oooooeeeeehhhhh!!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lips of Feature
	(properties
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 177 49 177 57 157 57 157 49
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 2 6)) ; Talk, Zipper
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance happyGammieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 4 2 4 1 2 self) ; "So? Did you do it, Larry?"
			)
			(2
				(gGame changeScore: 5 163)
				(gMessager say: 4 2 4 3 self) ; "I sure did, Gammie! I told you I would and I DID!"
			)
			(3
				(gMessager say: 4 2 4 4 5 self) ; "Would you like to be my first vic-, err, uh, suck-, ah, err, patient?!"
			)
			(4
				(= global171 2)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance talkTimer of Timer
	(properties)

	(method (cue)
		(switch global189
			(2
				(= global166 (ScriptID 0 7)) ; icon4
			)
			(1
				(= global166 (ScriptID 0 4)) ; icon1
			)
		)
		(gGame handsOn:)
		(cond
			((IsFlag 56)
				(ClearFlag 56)
				(gCurRoom doVerb: 7)
			)
			((IsFlag 55)
				(ClearFlag 55)
				(gMessager say: 0 0 14) ; "Whew! What's that smell? They must have spread steer manure on the lawn again!"
			)
		)
	)
)

(instance giveLarryHisKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(= cycles 2)
			)
			(1
				(gMessager say: 4 2 6 (++ register) self)
			)
			(2
				(switch register
					(3
						(= state 0)
						(gEgo get: 22) ; roomkey
						(gGame changeScore: 2 164 handsOn:)
					)
					(4)
					(else
						(= state 0)
					)
				)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance tellLarryAboutMachine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 21)
				(gMessager say: 4 2 11 1 3 self) ; "Say, Gam baby. I've got an idea! What if I, your friend Larry Laffer, could repair this little machine of yours, fix it up, make it right?"
			)
			(1
				(gGame changeScore: 3 162)
				(gMessager say: 4 2 11 4 5 self) ; "(SQUEALS) OH, LARRY! If you could do that, I'd be the happiest woman on Earth."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

