;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use System)

(public
	rm410 0
)

(local
	local0
	local1
	local2
)

(instance rm410 of LarryRoom
	(properties
		noun 1
		picture 410
		horizon 0
	)

	(method (init)
		(gGame handsOn:)
		((ScriptID 0 11) init: self) ; iconExit
		(breasts init:)
		(towel init:)
		(neck init:)
		(leftArm init:)
		(rightArm init:)
		(herMouth init:)
		(nose init:)
		(herEyes init:)
		((ScriptID 0 11) init: 400) ; iconExit
		(cond
			((not (IsFlag 64))
				(SetFlag 64)
				(gCurRoom setScript: firstTimeChar)
			)
			((IsFlag 39)
				(ClearFlag 39)
				(gCurRoom setScript: giveBatteries)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(switch local2
					(0
						(= temp0 10)
					)
					(1
						(= temp0 8)
					)
					(else
						(= temp0 9)
					)
				)
				(++ local2)
				(gMessager say: 1 1 temp0)
				(return 1)
			)
			(2 ; Talk
				(cond
					((IsFlag 204)
						(gMessager say: 1 2 14) ; "Come on, Larry. I know you can figure out someway past that silly electrical door lock."
						(return 1)
					)
					((IsFlag 205)
						(= temp0 17)
					)
					(else
						(switch (++ local0)
							(1
								(= temp0 2)
							)
							(2
								(= temp0 3)
							)
							(3
								(= temp0 4)
							)
							(4
								(gCurRoom setScript: getLost)
								(return 1)
							)
						)
					)
				)
				(gMessager say: 1 2 temp0)
				(return 1)
			)
			(25 ; batteries
				(self setScript: giveBatteries)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
	)
)

(instance getLost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 5 0 self) ; "Oh, tell me. Anything you want. I promise: if I can get it, it will be yours!"
			)
			(1
				(gGame handsOff: changeScore: 2 205)
				(= ticks 320)
			)
			(2
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance firstTimeChar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 16 0 self) ; "I hope you'll excuse the way I'm dressed..."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveBatteries of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo put: 1) ; batteries
				(gMessager say: 1 25 0 1 4 self) ; "Here's your batteries, Char. But, I might mention I had to go through a lot of trouble just to find them."
			)
			(2
				(gGame changeScore: 15 204)
				(if (IsFlag 203)
					(gMessager say: 1 25 6 1 3 self) ; "Good idea. I've already opened the door for us. Come on, Char. Let's go right now."
				else
					(gMessager say: 1 25 0 5 6 self) ; "But, don't they keep that door locked?"
				)
			)
			(3
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance towel of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 162 121 157 106 202 96 218 139 137 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance breasts of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 157 103 167 78 180 82 188 68 201 94 185 101 166 105
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(switch local1
					(0
						(= temp0 11)
					)
					(1
						(= temp0 12)
					)
					(else
						(= temp0 13)
					)
				)
				(++ local1)
				(gMessager say: 3 4 temp0)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftArm of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 215 126 187 57 193 50 207 53 217 65 234 139 219 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightArm of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 131 120 150 87 162 91 153 107 155 112 137 139 112 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance neck of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 174 65 183 51 187 68 179 81 166 78 160 63
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance herMouth of Feature
	(properties
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 176 52 176 55 164 57 161 54
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance nose of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 164 41 169 41 174 49 163 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance herEyes of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 181 32 182 38 151 43 148 37
					yourself:
				)
		)
		(super init: &rest)
	)
)

