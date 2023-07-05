;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Conversation)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	[local0 73] = [1 0 183 156 1 1 184 152 1 2 185 141 1 3 184 128 1 4 183 113 1 5 182 102 1 6 182 88 1 7 183 83 1 8 184 78 1 9 184 77 1 10 183 78 1 11 183 78 1 12 183 79 1 13 183 76 1 14 183 74 1 15 183 71 2 0 181 66 2 1 180 60 -32768]
	local73
	local74
	local75
	local76
	local77
	local78
	[local79 46] = [136 132 126 133 110 144 131 150 139 168 152 189 319 189 217 140 171 159 165 156 183 134 172 132 181 126 227 124 219 112 199 109 193 103 155 101 154 7 114 7 114 105 187 113 133 122]
	[local125 40] = [105 149 145 189 303 189 164 134 173 125 196 121 216 123 223 117 204 113 191 107 147 101 187 89 187 2 182 2 182 88 125 103 163 108 196 113 157 119 134 131]
	[local165 44] = [0 189 0 -10 319 -10 319 189 196 141 167 149 174 134 163 133 167 128 215 116 188 107 145 101 145 10 131 10 131 103 181 110 199 115 144 126 137 133 122 148 157 162 162 189]
	[local209 113] = [0 0 7 38 0 1 0 38 0 2 2 40 0 3 0 39 1 0 0 41 1 1 6 38 1 2 17 38 2 0 27 38 2 1 38 40 2 2 47 39 3 0 54 41 3 1 66 38 3 2 77 38 4 0 87 38 4 1 98 40 4 2 107 39 5 0 114 41 5 1 126 38 5 2 137 38 6 0 147 38 6 1 158 40 6 2 167 39 7 0 174 41 7 1 186 38 7 2 197 38 8 0 207 38 8 1 218 40 8 2 227 39 -32768]
	[local322 53] = [1 0 114 79 1 1 116 79 1 2 120 69 1 3 130 62 1 4 140 53 1 5 152 48 1 6 182 52 1 7 175 73 1 8 165 82 1 9 156 97 1 10 134 111 1 11 121 110 1 12 111 98 -32768]
	[local375 82] = [0 0 109 82 0 1 108 84 0 2 108 82 0 3 108 82 1 0 114 79 1 1 116 79 1 2 120 69 1 3 130 62 1 4 140 53 1 5 153 48 1 6 182 52 1 7 175 73 1 8 165 82 1 9 156 97 1 10 134 111 1 11 121 110 1 12 111 98 -32768 2 0 138 69 2 1 159 87 2 2 163 106 -32768]
	[local457 53] = [2 3 175 104 3 0 187 76 3 1 191 71 3 2 193 64 3 3 207 54 3 4 220 50 3 5 231 22 3 6 253 14 3 7 284 44 3 8 262 60 3 9 248 55 3 10 241 44 4 0 243 26 -32768]
)

(procedure (localproc_0 param1)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
	)
	(gCurRoom
		addObstacle:
			(switch (if (not argc) local73 else param1)
				(0
					(roomPoly type: PBarredAccess points: @local165 size: 22 yourself:)
				)
				(1
					(roomPoly type: PContainedAccess points: @local79 size: 23 yourself:)
				)
				(2
					(roomPoly type: PContainedAccess points: @local125 size: 20 yourself:)
				)
			)
	)
)

(instance rm630 of KQ6Room
	(properties
		noun 5
		picture 630
		north 640
		south 600
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(if (== gPrevRoomNum 640)
			(= local73 2)
			(gEgo
				init:
				reset: 5
				setScale: Scaler 40 20 140 80
				posn: 178 92
				setPri: 8
			)
			(gCurRoom setScript: fromEntranceScr)
		else
			(= local73 0)
			(gEgo init: reset: 3 posn: 225 188 setScale: FixedScaler 100)
			(gGame handsOn:)
		)
		(localproc_0)
		(bats
			init:
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			setCycle: MCyc @local209 bats
		)
		(zombie
			init:
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			setCycle: Walk
			hide:
			setScript: zombieScript 0 600
		)
		(gFeatures add: moon sky uWorldEntrance myPath eachElementDo: #init)
		(if (not (gEgo has: 17)) ; handkerchief
			(motherGhost
				init:
				ignoreActors: 1
				illegalBits: 0
				ignoreHorizon: 1
				setScript: motherGhostScript
			)
			(gGlobalSound number: 630 loop: -1 play:)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (not script)
			(switch (= temp0 (gEgo onControl: 1))
				(16384
					(self setScript: toEntranceScr)
				)
				(8192
					(if (== local73 0)
						(self setScript: downToMidScr)
					)
				)
				(4096
					(if (== local73 1)
						(self setScript: downToBottomScr)
					)
				)
				(2048
					(if (== local73 1)
						(self setScript: upToTopScr)
					)
				)
				(1024
					(if (== local73 2)
						(self setScript: upToMidScr)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== (gGlobalSound number:) 630)
			(gGlobalSound fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
		(LoadMany 0 942 964)
	)
)

(instance roomPoly of Polygon
	(properties)
)

(class FixedScaler of Code
	(properties
		frontSize 0
		backSize 0
		frontY 0
		backY 0
	)

	(method (init param1 param2)
		(= backSize (- (= frontSize param2) 1))
		(= param2 (/ (* param2 128) 100))
		(param1 scaleX: param2 scaleY: param2)
	)
)

(instance downToMidScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local74 ((gEgo mover:) finalX:))
					(= local75 ((gEgo mover:) finalY:))
					(= local76 ((gEgo mover:) caller:))
				)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					setScale:
						Scaler
						(/ (* (gEgo scaleX:) 100) 128)
						(- (/ (* (gEgo scaleX:) 100) 128) 1)
						(gEgo x:)
						(- (gEgo x:) 1)
					setPri: 9
					setLoop: 7
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(+ (gEgo y:) 50)
						self
				)
			)
			(2
				(gEgo setLoop: -1 setScale: FixedScaler 65)
				(localproc_0 1)
				(= seconds 2)
			)
			(3
				(gEgo posn: 136 175 setMotion: MoveTo 139 151 self)
			)
			(4
				(= local73 1)
				(if (not local76)
					(gGame handsOn:)
				)
				(if local74
					(if
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local74
								local75
							)
							15
						)
						(gEgo setMotion: PolyPath local74 local75 local76)
					)
					(= local74 0)
					(= local76 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance downToBottomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local74 ((gEgo mover:) finalX:))
					(= local75 ((gEgo mover:) finalY:))
					(= local76 ((gEgo mover:) caller:))
				)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					setScale:
						Scaler
						(/ (* (gEgo scaleX:) 100) 128)
						(- (/ (* (gEgo scaleX:) 100) 128) 1)
						(gEgo x:)
						(- (gEgo x:) 1)
					setPri: 8
					setLoop: 3
					setMotion: MoveTo 160 167 self
				)
			)
			(2
				(gEgo setLoop: -1 setScale: Scaler 40 20 140 80)
				(localproc_0 2)
				(= seconds 2)
			)
			(3
				(gEgo posn: 161 151 setMotion: MoveTo 160 134 self)
			)
			(4
				(= local73 2)
				(if (not local76)
					(gGame handsOn:)
				)
				(if local74
					(if
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local74
								local75
							)
							10
						)
						(gEgo setMotion: PolyPath local74 local75 local76)
					)
					(= local74 0)
					(= local76 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance upToTopScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local74 ((gEgo mover:) finalX:))
					(= local75 ((gEgo mover:) finalY:))
					(= local76 ((gEgo mover:) caller:))
				)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 35)
						self
				)
			)
			(2
				(localproc_0 0)
				(= seconds 2)
			)
			(3
				(gEgo
					setScale: FixedScaler 100
					setLoop: 2
					posn: 133 191
					setMotion: MoveTo 167 151 self
				)
			)
			(4
				(gEgo setPri: -1 setLoop: -1 setMotion: MoveTo 175 156 self)
			)
			(5
				(= local73 0)
				(if (not local76)
					(gGame handsOn:)
				)
				(if local74
					(if
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local74
								local75
							)
							20
						)
						(gEgo setMotion: PolyPath local74 local75 local76)
					)
					(= local74 0)
					(= local76 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance upToMidScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gEgo mover:) ((gEgo mover:) isKindOf: PolyPath))
					(= local74 ((gEgo mover:) finalX:))
					(= local75 ((gEgo mover:) finalY:))
					(= local76 ((gEgo mover:) caller:))
				)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 3)
						(+ (gEgo y:) 24)
						self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo
					setScale: FixedScaler 65
					setLoop: 2
					posn: 172 165
					setMotion: MoveTo 162 136 self
				)
			)
			(4
				(gEgo
					setLoop: -1
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 154 141 self
				)
			)
			(5
				(= local73 1)
				(localproc_0)
				(if (not local76)
					(gGame handsOn:)
				)
				(if local74
					(if
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local74
								local75
							)
							15
						)
						(gEgo setMotion: PolyPath local74 local75 local76)
					)
					(= local74 0)
					(= local76 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromEntranceScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: DPath 176 91 140 103 176 108 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toEntranceScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DPath 140 103 176 91 self)
			)
			(1
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance zombie of Actor
	(properties
		x 343
		y 258
		noun 11
		view 600
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if local73
				(gMessager say: noun theVerb 7 1) ; "Alexander will have to get a little closer to the undead creature if he wants to touch it."
			else
				(gGame handsOff:)
				(gCurRoom setScript: egoDeadScript 0 self)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(!= (motherGhost script:) getHankyScript)
				(<= (gEgo distanceTo: self) 10)
				(not local73)
			)
			(gGame handsOff:)
			(= local78 1)
			(gCurRoom setScript: egoDeadScript 0 self)
		)
		(super doit:)
	)
)

(instance ghoul1 of Actor
	(properties
		x 183
		y 156
		noun 8
		view 631
		loop 1
	)
)

(instance zombieScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 20 30))
			)
			(1
				(client
					view: register
					show:
					setMotion:
						DPath
						343
						258
						299
						187
						234
						183
						165
						186
						165
						242
						self
				)
				(++ register)
				(if (== register 602)
					(= register 603)
				)
				(if (> register 603)
					(= register 600)
				)
			)
			(2
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance egoDeadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(zombie setMotion: 0)
				(if local78
					(gMessager say: 9 0 5 1 self) ; "Uh, oh! One of the wandering ghouls brushes up against Alexander!"
				else
					(gMessager say: 11 5 0 1 self) ; "Alexander decides to get closer to the undead creature...."
				)
			)
			(1
				(cond
					(local78
						(= cycles 1)
					)
					((> (gEgo x:) (register x:))
						(gEgo
							setMotion:
								PolyPath
								(+ (register x:) 20)
								(register y:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(- (register x:) 20)
								(register y:)
								self
						)
					)
				)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 601 loop: 1 play:)
			)
			(2
				(if local78
					(gMessager say: 9 0 5 2 self) ; "The touch of the putred flesh dissolves the living matter like acid!"
				else
					(gMessager say: 11 5 0 2 self) ; "A decision that was definitely not one of his best."
				)
			)
			(3
				(gEgo
					view: 606
					normal: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(4
				(EgoDead 38) ; "Alexander's mother always told him to avoid bad ghouls!"
			)
		)
	)
)

(instance ghoul1Scr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client show: setCycle: MCyc @local0 self)
			)
			(1
				(client hide:)
				(= seconds (Random 20 30))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance myPath of Feature
	(properties
		noun 4
		onMeCheck 31746
	)
)

(instance uWorldEntrance of Feature
	(properties
		noun 10
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: 5 &rest)
			)
		)
	)
)

(instance sky of Feature
	(properties
		noun 7
		onMeCheck 16
	)
)

(instance moon of Feature
	(properties
		noun 3
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(5 ; Do
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: noun 0 0 0) ; "Alexander cannot get close enough to the moon to try that."
			)
		)
	)
)

(instance bats of Actor
	(properties
		x 7
		y 38
		noun 8
		view 630
	)

	(method (cue)
		(ghoul1
			init:
			setPri: 10
			cycleSpeed: 15
			ignoreActors: 1
			ignoreHorizon: 1
			setScript: ghoul1Scr
		)
		(self dispose:)
	)
)

(instance motherGhost of Actor
	(properties
		x 109
		y 82
		noun 2
		view 633
		cycleSpeed 10
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (gCurRoom script:))
				(== (script state:) 0)
				(script register:)
			)
			(gGame handsOff:)
			(self setScript: getHankyScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((gEgo has: 17) ; handkerchief
						(gMessager say: 2 2 1) ; "The woman's spirit is once again lost in her grief. She has nothing more to say to Alexander."
					)
					((!= (script state:) 0)
						(gGame handsOff:)
						(script register: 1)
					)
					(else
						(gGame handsOff:)
						(self setScript: getHankyScript)
					)
				)
			)
			(1 ; Look
				(if (gEgo has: 17) ; handkerchief
					(gMessager say: noun theVerb 1) ; "The mother ghost still grieves for her son, but she seems to have a small bit of hope that Alexander might find him."
				else
					(gMessager say: noun theVerb 2) ; "The spirit of a woman hangs like a puff of smoke in the air. She is weeping and appears to be very distressed about something."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance motherGhostScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 0 posn: 109 82 cycleSpeed: 20 setCycle: Fwd)
				(= seconds (Random 5 15))
			)
			(1
				(gMessager say: 9 0 4 1 self) ; "Ali! Where is my little boy? Ali!"
			)
			(2
				(client cycleSpeed: 5 setCycle: MCyc @local322 self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance getHankyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local77 (zombie mover:))
				(zombie mover: 0)
				(gEgo setMotion: PolyPath 205 162 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(theConv
					add: -1 2 2 2 1 ; "Why do you not rest, sad spirit?"
					add: -1 2 2 2 2 ; "Rest? I cannot rest! My son is lost!"
					add: -1 2 2 2 3 ; "Lost? You mean in this realm?"
					add: -1 2 2 2 4 ; "No! His spirit is stuck in the land of the living--probably looking for me! But I cannot leave to go show him the way! My poor Ali!"
					add: -1 2 2 2 5 ; "Is there anything I can do?"
					add: -1 2 2 2 6 ; "Take this handkerchief. If you get back to the land of the living and find him, tell him that his mother is waiting for him here."
					add: -1 2 2 2 7 ; "By this kiss, he'll be able to find his way to the Realm of the Dead."
					init: self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 2 2 2 8 self) ; "I'll do my best to find him."
			)
			(5
				(gMessager say: 2 2 2 9 self) ; "Thank you, thank you! Oh, my Ali!"
			)
			(6
				(motherGhost cycleSpeed: 15 setCycle: MCyc @local375 self)
			)
			(7
				(motherGhost setLoop: 2 cel: 0 posn: 138 69)
				(gEgo
					normal: 0
					view: 633
					setLoop: 5
					cel: 0
					posn: (- (gEgo x:) 11) (- (gEgo y:) 1)
				)
				(= cycles 10)
			)
			(8
				(motherGhost cel: 1 posn: 159 87)
				(gEgo cel: 1)
				(= cycles 10)
			)
			(9
				(motherGhost cel: 2 posn: 163 106)
				(gEgo cel: 2)
				(= cycles 10)
			)
			(10
				(motherGhost setCycle: MCyc @local457 self)
				(gEgo cel: 3)
				(= cycles 3)
			)
			(11
				(gGame givePoints: 1)
				(gEgo
					get: 17 ; handkerchief
					oldScaleSignal: 0
					reset: 7
					setScale: FixedScaler 100
					posn: 210 167
				)
			)
			(12
				(motherGhost view: 632 setLoop: 0 cel: 0 setCycle: End self)
				(gGlobalSound fade:)
			)
			(13
				(gGlobalSound number: 600 loop: -1 play:)
				(gGame handsOn:)
				(motherGhost dispose:)
				(if local77
					(zombie mover: local77)
				)
				(= local77 0)
			)
		)
	)
)

(instance theConv of Conversation
	(properties)
)

