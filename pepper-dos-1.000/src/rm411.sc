;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use smell)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm411 0
)

(instance rm411 of ADRoom
	(properties
		noun 44
		picture 411
		horizon 103
		east 420
		south 410
		vanishingY -60
	)

	(method (init)
		(gGame setEgo: (ScriptID 895 1)) ; lockjaw
		(gEgo init: normalize: x: 170 y: 170)
		(switch gPrevRoomNum
			(south
				(gGame handsOn:)
			)
			(east
				(gEgo x: 218 y: 155 setHeading: 270)
				(gCurRoom setScript: sWalkIn)
			)
			(else
				(gGame handsOn:)
			)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 318 0 319 189 267 189 267 172 223 149 217 149 210 163 101 163 52 164 52 189
					yourself:
				)
		)
		(if (not (IsFlag 409))
			(shroud init: stopUpd:)
		else
			(shroud view: 438 loop: 0 cel: 0 init: addToPic:)
			(shroudFea init:)
			(shrine init:)
		)
		(if (IsFlag 48)
			(chewHole init: stopUpd:)
		)
		(mouseHole init:)
		(boxes init:)
		(boxesRt init:)
		(clothesR init:)
		(clothesL init:)
		(collar1 init:)
		(collar2 init:)
		(collar3 init:)
		(collar4 init:)
		(collar5 init:)
		(collar6 init:)
		(dogAngel init:)
		(southEFeature init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (& temp0 $0002) (IsFlag 48))
				(gCurRoom setScript: sThruHole)
			)
		)
	)
)

(instance sThruHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(Face gEgo mouseHole self)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance sPawEnterHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 47 30 27 0 self) ; "Lockjaw decides to take his chances and sneak through the rat hole!"
			)
			(1
				(client setScript: sThruHole)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 411 2)
				(= cycles 1)
			)
			(1
				(gMessager say: 47 89 0 0 self) ; "Lockjaw chews through the wood like a buzzsaw!"
			)
			(2
				(sFX number: 4110 loop: 1 play: self)
				(gEgo view: 425 loop: 3 cel: 0 posn: 236 153 setCycle: Fwd)
			)
			(3
				(chewHole init: stopUpd:)
				(gEgo posn: 218 152 normalize: 807 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullShroudDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 409 2)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 205 156 self)
			)
			(2
				(gMessager say: 35 89 0 0 self) ; "Lockjaw gathers his courage, and grabs a mouthful of shroud."
			)
			(3
				(client setScript: sShroudDown)
			)
		)
	)
)

(instance sShroudDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 421 loop: 0 cel: 1 posn: 159 162)
				(sFX number: 905 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(shroud hide:)
				(gEgo setCycle: End self)
			)
			(2
				(sFX number: 415 loop: 1 play:)
				(shrine init:)
				(shroud view: 438 loop: 0 cel: 0 addToPic:)
				(shroudFea init:)
				(= cycles 1)
			)
			(3
				(gEgo
					show:
					normalize: 807 5
					posn: 199 157
					setMotion: MoveTo 186 163 self
				)
			)
			(4
				(gEgo normalize: 807 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPawShroudDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 409 2)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 205 156 self)
			)
			(2
				(gMessager say: 35 30 0 0 self) ; "Lockjaw gathers his courage, and reaches for the shroud!"
			)
			(3
				(client setScript: sShroudDown)
			)
		)
	)
)

(instance sSmellMouseHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 410 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 808
					loop: 4
					cel: 0
					setSpeed: 6
					posn: 220 151
					setCycle: CT 4 1 self
				)
			)
			(2
				(sFX number: 911 loop: 1 play: self)
				(gEgo setCycle: CycleBet 4 5 -1)
			)
			(3
				(gEgo setCycle: 0)
				(proc875_3 2 self)
			)
			(4
				(gMessager say: 47 86 0 0 self) ; "Mmmmm! Lockjaw smells a rat, and it's not General Pugh!"
			)
			(5
				(gEgo normalize: 807 0 posn: 215 150)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shroud of Prop
	(properties
		x 159
		y 162
		noun 35
		view 421
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (IsFlag 409)
					(gMessager say: 35 6 3) ; "The shroud looks just as bad on the ground as it did on the doggie memorial."
				else
					(gMessager say: 35 6) ; "The massive, shrouded object has an ominous look about it. It makes Lockjaw nervous."
				)
			)
			(30 ; Paw
				(if (IsFlag 409)
					(gMessager say: 35 30 3) ; "Lockjaw doesn't want to touch THAT!"
				else
					(gCurRoom setScript: sPawShroudDown)
				)
			)
			(89 ; Teeth
				(if (IsFlag 409)
					(gMessager say: 35 89 3) ; "Lockjaw doesn't EVEN want to know what that tastes like."
				else
					(gCurRoom setScript: sPullShroudDown)
				)
			)
			(84 ; Trivia
				(if (IsFlag 409)
					(gMessager say: 44 84) ; "FALSE. Secret passages and hidden rooms weren't common in colonial American houses. Some of the older buildings in Europe had them at this time, though. Secret rooms became popular in Victorian England, about 100 years after the American Colonial era, but they never really caught on in the United States."
				else
					(gMessager say: 35 84) ; "How can you get a Truth Icon message on this when you don't know what it is, huh? Go on, take a peek!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shroudFea of Feature
	(properties
		x 136
		y 150
		noun 35
		nsTop 142
		nsLeft 59
		nsBottom 158
		nsRight 214
		sightAngle 40
	)

	(method (doVerb theVerb)
		(shroud doVerb: theVerb)
	)
)

(instance mouseHole of Feature
	(properties
		x 230
		y 140
		noun 47
		nsTop 131
		nsLeft 224
		nsBottom 150
		nsRight 237
		approachX 215
		approachY 150
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(if (IsFlag 48)
					(gMessager say: 47 89 26) ; "Lockjaw has already enlarged the rat hole. He doesn't need to chew it any more."
				else
					(gCurRoom setScript: sTeethOnHole)
					(SetFlag 48)
				)
			)
			(30 ; Paw
				(if (IsFlag 48)
					(gCurRoom setScript: sPawEnterHole)
				else
					(gMessager say: 47 30) ; "Lockjaw would love to get in there, but he can't dig his way through wood."
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sSmellMouseHole)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chewHole of View
	(properties
		x 223
		y 130
		noun 47
		approachX 215
		approachY 150
		_approachVerbs 121
		view 425
		loop 2
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(mouseHole doVerb: theVerb)
	)
)

(instance boxes of Feature
	(properties
		x 91
		y 31
		noun 34
		nsTop 13
		nsLeft 75
		nsBottom 49
		nsRight 107
		approachX 102
		approachY 154
		approachDist 139
		_approachVerbs 121
	)
)

(instance boxesRt of Feature
	(properties
		x 212
		y 31
		noun 34
		nsTop 12
		nsLeft 187
		nsBottom 51
		nsRight 237
		sightAngle 40
		approachX 102
		approachY 154
		approachDist 139
		_approachVerbs 121
	)
)

(instance clothesR of Feature
	(properties
		x 75
		y 88
		noun 33
		nsTop 44
		nsLeft 58
		nsBottom 133
		nsRight 92
		approachX 75
		approachY 88
		_approachVerbs 121
	)
)

(instance clothesL of Feature
	(properties
		x 239
		y 74
		noun 33
		nsTop 53
		nsLeft 231
		nsBottom 96
		nsRight 248
		approachX 239
		approachY 74
		_approachVerbs 121
	)
)

(instance collar1 of Feature
	(properties
		x 134
		y 96
		noun 38
		nsTop 108
		nsLeft 124
		nsBottom 130
		nsRight 145
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(89 ; Teeth
				(gMessager say: 37 89) ; "No way! Lockjaw has respect for the dead!"
			)
			(86 ; Nose
				(gMessager say: 37 86) ; "Lockjaw doesn't even want to KNOW what that smells like."
			)
			(30 ; Paw
				(gMessager say: 37 30) ; "There's no way Lockjaw's going to touch that!"
			)
			(84 ; Trivia
				(gMessager say: 37 84) ; "FALSE. Pet cemeteries were just about unheard of in colonial times, and certainly no one put dog memorials in their closets. Pet cemeteries weren't common until the 20th century."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance collar2 of Feature
	(properties
		x 131
		y 96
		noun 39
		nsTop 72
		nsLeft 120
		nsBottom 95
		nsRight 142
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(else
				(collar1 doVerb: theVerb)
			)
		)
	)
)

(instance collar3 of Feature
	(properties
		x 155
		y 96
		noun 40
		nsTop 57
		nsLeft 143
		nsBottom 83
		nsRight 167
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(else
				(collar1 doVerb: theVerb)
			)
		)
	)
)

(instance collar4 of Feature
	(properties
		x 179
		y 96
		noun 41
		nsTop 75
		nsLeft 169
		nsBottom 97
		nsRight 189
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(else
				(collar1 doVerb: theVerb)
			)
		)
	)
)

(instance collar5 of Feature
	(properties
		x 177
		y 96
		noun 42
		nsTop 106
		nsLeft 167
		nsBottom 128
		nsRight 188
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(else
				(collar1 doVerb: theVerb)
			)
		)
	)
)

(instance collar6 of Feature
	(properties
		x 155
		y 96
		noun 43
		nsTop 84
		nsLeft 145
		nsBottom 114
		nsRight 165
		approachX 155
		approachY 154
		_approachVerbs 121
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: noun 6) ; "The brass plaque by the collar says:"
			)
			(else
				(collar1 doVerb: theVerb)
			)
		)
	)
)

(instance dogAngel of Feature
	(properties
		x 153
		y 37
		noun 46
		nsTop 19
		nsLeft 128
		nsBottom 55
		nsRight 179
		approachX 155
		approachY 154
		_approachVerbs 121
	)
)

(instance shrine of Feature
	(properties
		x 154
		y 95
		noun 37
		nsTop 56
		nsLeft 109
		nsBottom 134
		nsRight 200
		approachX 155
		approachY 154
		_approachVerbs 121
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 168
		nsLeft 61
		nsBottom 180
		nsRight 253
		cursor 910
		exitDir 3
		noun 44
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

