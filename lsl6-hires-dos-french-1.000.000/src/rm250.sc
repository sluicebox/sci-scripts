;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Polygon)
(use Feature)
(use System)

(public
	rm250 0
)

(local
	local0 = 1
	local1
)

(instance rm250 of LarryRoom
	(properties
		noun 1
		picture 250
		horizon 0
	)

	(method (init)
		(super init: &rest)
		(SetFlag 27)
		(SetFlag 102)
		(leftBreast init:)
		(stomach init:)
		(arm init:)
		(otherArm init:)
		(neck init:)
		(herMouth init:)
		(hair init:)
		((ScriptID 0 11) init: backOut) ; iconExit
		(gGame handsOn:)
	)

	(method (cue)
		(self setScript: toTowerScene)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(cond
					((and (IsFlag 7) (IsFlag 150))
						(gMessager say: 1 2 14) ; "Oh, Larry. Have you found a bungee tower key for me yet?"
						(return 1)
					)
					((IsFlag 7)
						(gMessager say: 1 2 10) ; "Oh, Larry! Have you figured out a way for me to gain access to the bungee jumping tower yet?"
						(return 1)
					)
					(else
						(switch local0
							(1
								(= temp0 1)
							)
							(2
								(= temp0 3)
							)
							(3
								(= temp0 4)
							)
							(4
								(= temp0 5)
							)
							(5
								(= temp0 6)
							)
							(6
								(= temp0 7)
							)
							(7
								(gGame changeScore: 2 170)
								(SetFlag 7)
								(= temp0 8)
							)
						)
						(++ local0)
						(gMessager say: 1 2 temp0)
						(return 1)
					)
				)
			)
			(52 ; randomKey [ filed ]
				(SetFlag 8)
				(gGame changeScore: 15 171)
				(gMessager sayRange: 1 52 10 1 3 self) ; "Look what I have for you, Merr. Your own personal copy of the key to the bungee jumping tower!"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (not local1)
			((ScriptID 0 11) dispose:) ; iconExit
		)
		(super dispose:)
	)
)

(instance backOut of Script
	(properties)

	(method (cue)
		(= local1 1)
		((ScriptID 0 11) dispose:) ; iconExit
		(gCurRoom newRoom: 240)
	)
)

(instance toTowerScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 21) ; randomKey
				(= local1 1)
				((ScriptID 0 11) dispose:) ; iconExit
				(gGame handsOff: hideControls:)
				(= cycles 2)
			)
			(1
				(= cycles 2)
			)
			(2
				(gGlobalSound1 fade: 0 5 10 1)
				(gThePlane drawPic: -1 10)
				(gCast eachElementDo: #hide)
				(= seconds 5)
			)
			(3
				(gMessager say: 1 52 10 4 self) ; "(WITH MUCH ECHO) Later that night..."
			)
			(4
				(= seconds 6)
			)
			(5
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance leftBreast of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 123 147 129 139 129 132 125 127 116 130 106 144 94 202 103 198 121 193 130 183 135 176 136 165 132 162 124 156 123
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stomach of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 139 138 130 178 139 141 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance arm of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 90 118 88 88 76 76 66 75 61 132 27 143 15 147 37 137 39 123 48 109 62 135 69 155 69 142 89
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance otherArm of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 137 210 82 223 89 229 107 226 119 216 136 200 137
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
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 72 170 67 194 56 196 76 189 91 164 85
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
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 55 169 51 178 54 174 58 169 59
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hair of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 25 160 11 179 3 205 5 215 16 228 77 221 85 200 73 189 29 158 33 153 40
					yourself:
				)
		)
		(super init: &rest)
	)
)

