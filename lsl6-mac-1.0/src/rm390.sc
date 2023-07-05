;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use Timer)
(use System)

(public
	rm390 0
)

(local
	local0
	local1 = -1
	local2
)

(instance rm390 of LarryRoom
	(properties
		noun 1
		picture 390
		style 15
	)

	(method (init)
		(gGlobalSound1 number: 0 stop:)
		(if (or (!= gPrevRoomNum 320) (not (gGlobalSound2 handle:)))
			(gGlobalSound2 number: 320 loop: -1 play: 90)
		)
		(roseEyes init:)
		(breasts init:)
		(hair init:)
		(nose init:)
		(roseMouth init:)
		(halterTop init:)
		(leftArm init:)
		(rightArm init:)
		(neck init:)
		(= global166 (ScriptID 0 4)) ; icon1
		(gGame handsOn:)
		((ScriptID 0 11) init: 320 enable:) ; iconExit
		(fan init:)
		(lubricant init:)
		(pipe init:)
		(super init: &rest)
		(= local1 (gNarrator talkWidth:))
		(gNarrator x: 5 y: 10 talkWidth: 130)
		(if (IsFlag 55)
			(gGame handsOff:)
			(stenchTimer setCycle: stenchTimer 3)
		else
			(gGame handsOn:)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; flowers
				(gCurRoom setScript: giveFlowersScr)
			)
			(2 ; Talk
				(switch (++ local0)
					(1
						(gMessager say: 1 2 1 0) ; "Welcome to La Costa Lotta's High Colonic Treatment Suite, Mr. Laffer. Your presence here is welcome to me, Rose Eleeta, on your attendant person duty."
					)
					(2
						(gMessager say: 1 2 2 0) ; "How long have you been in this country, Rose?"
					)
					(3
						(gMessager say: 1 2 3 0) ; "What brought you to America?"
					)
					(4
						(gMessager say: 1 2 4 0) ; "What I mean is, why did you leave Spain and journey all this way?"
					)
					(5
						(gMessager say: 1 2 5 0) ; "Rose, would you like to try a little something special with me? I consider myself quite the continental type, very sophisticated and urbane."
					)
					(else
						(gMessager say: 1 2 6 0) ; "I can understand how a woman might want a gift. But what exactly would please you, Rose?"
					)
				)
				(return 1)
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

	(method (newRoom newRoomNumber)
		(gNarrator x: -1 y: -1 talkWidth: local1)
		(super newRoom: newRoomNumber)
	)
)

(instance roseEyes of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 150 34 176 32 177 42 169 44 150 45
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
					init: 130 94 142 95 143 101 157 96 175 101 175 113 166 112 156 108 134 107 117 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hair of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 185 78 194 75 194 66 190 60 189 52 188 44 182 41 178 27 154 24 149 32 148 44 151 59 153 69 158 78 163 83 152 84 139 72 137 53 142 46 143 26 144 14 161 7 186 9 199 27 215 63 201 85 185 84 183 77
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance nose of Feature
	(properties
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 154 41 162 39 166 48 158 52 153 47
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance roseMouth of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 150 50 169 50 169 64 150 64
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance halterTop of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 178 114 184 123 191 126 191 133 186 133 178 139 160 139 125 133 116 128 111 116 106 108 111 102 119 103
					yourself:
				)
		)
		(super init: &rest)
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
					init: 188 83 204 83 247 139 221 139 189 109
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
					init: 138 55 142 81 135 82 109 60 93 38 94 30 111 23 147 16 142 29 118 41
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance neck of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 161 67 182 61 185 87 158 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local2)
					(= local2 1)
					(super doVerb: theVerb)
				else
					(gMessager say: 8 4 7) ; "Since I have permission, I'm going to touch your neck."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fan of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 63 0 69 10 65 20 78 30 75 53 61 55 54 49 20 72 0 58
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(cond
			((Message msgGET 390 noun theVerb 0 1 @temp0)
				(gMessager say: 11 theVerb)
			)
			((Message msgGET 320 2 theVerb 0 1 @temp0)
				(gMessager say: 2 theVerb 0 0 0 320)
			)
			(else
				(gMessager say: 11 0) ; "Leave the fan alone. Focus your attention on Rose."
			)
		)
	)
)

(instance lubricant of Feature
	(properties
		noun 7
		modNum 320
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 107 31 109 31 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (Message msgGET 320 noun theVerb 0 1 @temp0)
			(gMessager say: noun theVerb 0 0 0 320)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance pipe of Feature
	(properties
		noun 10
		modNum 320
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 308 0 304 29 302 85 312 86 312 108 302 108 302 137 246 138 232 121 238 120 239 110 230 108 228 89 237 86 225 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gMessager say: 10 0 0 0 0 320) ; "What a massive piece of plumbing."
	)
)

(instance giveFlowersScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame changeScore: 5 198)
				(SetFlag 67)
				(= seconds 4)
			)
			(1
				(gGlobalSound2 fade: 127 10 10 0)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance stenchTimer of Timer
	(properties)

	(method (cue)
		(gMessager say: 0 0 10 0 gCurRoom) ; "Ei! Carrumba!! What is that horrrrrible ca-ca smell?"
		(ClearFlag 55)
	)
)

