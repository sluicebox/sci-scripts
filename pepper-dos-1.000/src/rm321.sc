;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm321 0
)

(local
	local0
	local1
)

(instance rm321 of ADRoom
	(properties
		noun 41
		picture 321
		vanishingY -60
	)

	(method (init)
		(gGame setEgo: (ScriptID 895 0)) ; pepper
		(gEgo init: normalize: setScale: 0 posn: 192 140)
		(if (not (IsFlag 158))
			(SetFlag 158)
		)
		(if (== gPrevRoomNum 200)
			(pigeon view: 324 setLoop: 4 x: 89 y: 93 setCycle: End init:)
			((ScriptID 895 0) posn: 117 128) ; pepper
			(self setScript: birdComesBackScr)
		else
			(cond
				((IsFlag 163)
					(atticWindow noun: 45)
					(birdCage noun: 43)
				)
				((not (IsFlag 78))
					(= local0 1)
					(birdCage noun: 42)
					(pigeon init:)
				)
				((not (IsFlag 168))
					(= local0 0)
					(birdCage noun: 43)
					(pigeon
						view: 324
						setPri: 14
						setLoop: 3
						cel: 0
						noun: 65
						posn: 155 84
						setCycle: Fwd
						setScript: birdFlyingScr
						init:
					)
				)
				((and (IsFlag 156) (not (IsFlag 163)))
					(pigeon
						view: 324
						setLoop: 8
						cel: 0
						posn: 89 75
						setCycle: Fwd
						setScript: birdContinuesToPeckScr
						init:
					)
					(letter init: stopUpd:)
				)
				((and (IsFlag 78) (not (IsFlag 162)))
					(= local0 0)
					(pigeon loop: 2 cel: 0 posn: 89 87 noun: 64 init:)
					(letter init: stopUpd:)
				)
			)
			(self setScript: startScr)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 215 142 191 138 147 139 107 124 39 140 118 176 290 176 300 163 231 162 245 143
					yourself:
				)
		)
		(birdCage init: setOnMeCheck: 1 4)
		(atticWindow init:)
		(crate1 init: setOnMeCheck: 1 8)
		(crate2 init: setOnMeCheck: 1 16)
		(crate3 init: setOnMeCheck: 1 64)
		(crate4 init: setOnMeCheck: 1 32)
		(rope init: setOnMeCheck: 1 128)
		(bell init: setOnMeCheck: 1 2048)
		(barrel init: setOnMeCheck: 1 1024)
		(atticJunk init: setOnMeCheck: 1 256)
		(lightningRod init: setOnMeCheck: 1 16384)
		(hatch init: setOnMeCheck: 1 2)
		(if (IsFlag 78)
			(birdCageDoor init: stopUpd: ignoreActors: 1)
		)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(gCurRoom setScript: gotoBenWorkRoomScr)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance startScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not (IsFlag 156)) (not (IsFlag 152)))
					(windowView init: stopUpd:)
				)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					setSpeed: 5
					setCycle: Walk
					setMotion: MoveTo 169 144 self
				)
			)
			(2
				(gGame handsOn:)
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance openBirdCageDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 136 130 self
				)
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 325
					setLoop: 0
					cel: 3
					posn: 136 130
					setSpeed: 8
					setCycle: End self
				)
				(gLongSong2 number: 3204 setLoop: 1 play:)
			)
			(3
				(birdCageDoor init: ignoreActors: 1 stopUpd:)
				((ScriptID 895 0) ; pepper
					normalize:
					setSpeed: local1
					setCycle: Walk
					setMotion: MoveTo 126 136 self
				)
			)
			(4
				((ScriptID 895 0) normalize: setHeading: 185) ; pepper
				(= cycles 1)
			)
			(5
				(birdCage noun: 43)
				(self dispose:)
			)
		)
	)
)

(instance letBirdOutCageScr of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			((and (IsFlag 152) (== state 2))
				(self cue:)
			)
			((and (gCurRoom script:) (& temp0 $0002))
				(self setScript: gotoBenWorkRoomScr)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 78)
				(pigeonTurnHeadScr dispose:)
				(= cycles 1)
			)
			(1
				(self setScript: openBirdCageDoorScr self)
			)
			(2
				(pigeon
					view: 324
					setPri: 14
					setLoop: 3
					cel: 0
					noun: 65
					posn: (pigeon x:) (- (pigeon y:) 20)
					setCycle: Fwd
				)
				(gGame handsOn:)
			)
			(3
				(gLongSong fade:)
				(pigeon
					setLoop: 7
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 94 81 self
				)
			)
			(4
				(pigeon
					view: 324
					setLoop: 7
					setPri: 3
					setCycle: Fwd
					setScale: Scaler 104 31 94 60
					setMotion: MoveTo 107 62 self
				)
			)
			(5
				(gLongSong number: 321 setLoop: -1 play:)
				(gMessager say: 44 7 0 2 3 self) ; "The pigeon seems to be heading for Penn Mansion."
			)
			(6
				(pigeon setScale: 0 dispose:)
				(= ticks 30)
			)
			(7
				(gCurRoom newRoom: 200)
				(SetFlag 152)
				(SetFlag 168)
				(self dispose:)
			)
		)
	)
)

(instance birdFlyingScr of Script
	(properties)

	(method (doit)
		(if (and (IsFlag 152) (== state 1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 78)
				(pigeonTurnHeadScr dispose:)
				(= cycles 1)
			)
			(1
				(pigeon
					view: 324
					setPri: 14
					setLoop: 3
					cel: 0
					noun: 65
					posn: (pigeon x:) (- (pigeon y:) 20)
					setCycle: Fwd
				)
				(gGame handsOn:)
			)
			(2
				(gLongSong fade:)
				(pigeon
					setLoop: 7
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 94 81 self
				)
			)
			(3
				(pigeon
					view: 324
					setLoop: 7
					setCycle: Fwd
					setScale: Scaler 104 31 94 60
					setMotion: MoveTo 107 62 self
				)
			)
			(4
				(gLongSong number: 321 setLoop: -1 play:)
				(gMessager say: 44 7 0 2 3 self) ; "The pigeon seems to be heading for Penn Mansion."
			)
			(5
				(gCurRoom newRoom: 200)
				(SetFlag 152)
				(SetFlag 168)
				(pigeon setScale: 0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance letBirdAllTheWayOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 78)
				(SetFlag 168)
				(pigeonTurnHeadScr dispose:)
				(= cycles 5)
			)
			(1
				(gMessager say: 42 7 0 1 self) ; "Boy, he looks miserable in there."
			)
			(2
				(self setScript: openBirdCageDoorScr self)
			)
			(3
				((ScriptID 895 0) ignoreActors: 1) ; pepper
				(pigeon
					view: 324
					setLoop: 7
					cel: 0
					posn: 157 98
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 86 71 self
				)
				(= seconds 2)
			)
			(4
				(gMessager say: 42 7 0 2) ; "Here you go, little pigeon. Fly away!"
			)
			(5
				(pigeon
					view: 324
					setLoop: 7
					setPri: 3
					setCycle: Fwd
					setScale: Scaler 104 31 94 60
					setMotion: MoveTo 107 62 self
				)
			)
			(6
				(gLongSong number: 321 setLoop: -1 play:)
				(= cycles 1)
			)
			(7
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance birdComesBackScr of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 ((ScriptID 895 0) onControl: 1)) ; pepper
		(cond
			((and (== state 4) (not (gCast contains: letter)))
				(self cue:)
			)
			((and (gCurRoom script:) (& temp0 $0002))
				(self setScript: gotoBenWorkRoomScr)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 156)
				(= cycles 1)
			)
			(1
				(pigeon
					view: 324
					setLoop: 4
					cel: 0
					posn: 90 93
					setCycle: End self
				)
			)
			(2
				(letter init: stopUpd:)
				(birdCage noun: 43)
				(= cycles 2)
			)
			(3
				(pigeon view: 324 setLoop: 5 posn: 89 75 setCycle: End self)
			)
			(4
				(pigeon view: 324 setLoop: 8 cel: 0 posn: 89 75 noun: 64)
				(self setScript: birdPeckScr)
				(gGame handsOn:)
			)
			(5
				(birdPeckScr dispose:)
				(gGame handsOff:)
				(= ticks 50)
			)
			(6
				(SetFlag 163)
				(pigeon
					setLoop: 7
					cel: 0
					posn: (pigeon x:) (- (pigeon y:) 5)
					setCycle: Fwd
					setMotion: MoveTo 94 81 self
				)
			)
			(7
				(pigeon
					view: 324
					setLoop: 7
					setCycle: Fwd
					setScale: Scaler 104 31 94 60
					setMotion: MoveTo 107 62 self
				)
			)
			(8
				(birdCage noun: 43)
				(= cycles 2)
			)
			(9
				(pigeon setCycle: 0)
				(gGame handsOn:)
				(pigeon dispose:)
				(self dispose:)
			)
		)
	)
)

(instance birdContinuesToPeckScr of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 ((ScriptID 895 0) onControl: 1)) ; pepper
		(cond
			((and (== state 1) (not (gCast contains: letter)))
				(self cue:)
			)
			((and (gCurRoom script:) (& temp0 $0002))
				(self setScript: gotoBenWorkRoomScr)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 156)
				(= cycles 1)
			)
			(1
				(pigeon view: 324 setLoop: 8 cel: 0 posn: 89 75 noun: 64)
				(self setScript: birdPeckScr)
				(gGame handsOn:)
			)
			(2
				(birdPeckScr dispose:)
				(gGame handsOff:)
				(= ticks 50)
			)
			(3
				(pigeon
					setLoop: 7
					cel: 0
					posn: (pigeon x:) (- (pigeon y:) 5)
					setCycle: Fwd
					setMotion: MoveTo 94 81 self
				)
			)
			(4
				(pigeon
					view: 324
					setLoop: 7
					setCycle: Fwd
					setScale: Scaler 104 31 94 60
					setMotion: MoveTo 107 62 self
				)
			)
			(5
				(pigeon dispose:)
				(birdCage noun: 43)
				(= cycles 2)
			)
			(6
				(pigeon setCycle: 0)
				(SetFlag 163)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gotoBenWorkRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 320)
				(self dispose:)
			)
		)
	)
)

(instance birdPeckScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(pigeon setCycle: End self)
			)
			(2
				(gLongSong2 number: 3206 setLoop: 1 play:)
				(= cycles 1)
			)
			(3
				(pigeon setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance takeLetterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 163)
				(= cycles 1)
			)
			(1
				(gMessager say: 60 7 0 1 self) ; "What do you have there, little feathery guy?"
			)
			(2
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 115 120 self
				)
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(= ticks 60)
			)
			(4
				(gMessager say: 60 7 0 2 self) ; "Let's just see what this is."
			)
			(5
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(6
				(letter dispose:)
				(gEgo get: 28) ; King_s_Letter
				(= cycles 1)
			)
			(7
				((ScriptID 895 0) cel: 5 setCycle: Beg self) ; pepper
			)
			(8
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(9
				(gMessager say: 60 7 0 3 5 self) ; ""To General Hugh Pugh II, Acting Governor of Philadelphia, from..." THE KING OF ENGLAND?! Oh, wow! He's talking about the Stamp Act!"
			)
			(10
				(pigeon setCycle: 0)
				(SetFlag 162)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pigeon of Actor
	(properties
		x 155
		y 104
		noun 65
		view 324
		loop 2
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 156)
				(self noun: 64)
			)
			((not (IsFlag 78))
				(self noun: 0)
			)
			(else
				(self noun: 65)
			)
		)
		(self setPri: 3)
		(if local0
			(self setScript: pigeonTurnHeadScr)
		)
	)

	(method (doVerb theVerb)
		(if (not (IsFlag 78))
			(birdCage doVerb: theVerb &rest)
			(return 0)
		)
		(return
			(switch theVerb
				(7 ; Do
					(pigeonTurnHeadScr dispose:)
					(if (not (IsFlag 78))
						(if (IsFlag 152)
							(if (gCurRoom script:)
								((gCurRoom script:)
									setScript: letBirdAllTheWayOutScr
								)
							else
								(gCurRoom setScript: letBirdAllTheWayOutScr)
							)
						else
							(gCurRoom setScript: letBirdOutCageScr)
						)
					else
						(super doVerb: 7 &rest)
					)
				)
				(84 ; Trivia
					(gLongSong2 number: 927 setLoop: 1 play:)
					(super doVerb: theVerb &rest)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance birdCage of Feature
	(properties
		x 155
		y 74
		noun 42
		nsTop 52
		nsLeft 135
		nsBottom 96
		nsRight 175
		sightAngle 40
		approachX 147
		approachY 135
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(pigeonTurnHeadScr dispose:)
				(gGame points: 317 1)
				(if (not (IsFlag 78))
					(if (IsFlag 152)
						(gCurRoom setScript: letBirdAllTheWayOutScr)
					else
						(gCurRoom setScript: letBirdOutCageScr)
					)
				else
					(= noun 43)
					(gMessager say: 43 7) ; "Pepper doesn't want the empty pigeon cage."
				)
			)
			(84 ; Trivia
				(if (not (IsFlag 78))
					(gLongSong2 number: 927 setLoop: 1 play:)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hatch of Feature
	(properties
		noun 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: leaveRoomScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdCageDoor of View
	(properties
		x 150
		y 95
		view 325
		loop 3
		cel 1
	)

	(method (doVerb theVerb)
		(birdCage doVerb: theVerb &rest)
	)
)

(instance pigeonTurnHeadScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pigeon setSpeed: 8 setCycle: End self)
			)
			(1
				(= seconds 9)
			)
			(2
				(pigeon setCycle: Beg self)
			)
			(3
				(= seconds 9)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance atticWindow of Feature
	(properties
		x 89
		y 60
		noun 44
		nsTop 32
		nsLeft 66
		nsBottom 53
		nsRight 113
		sightAngle 40
		approachX 98
		approachY 123
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					((and (not (gEgo has: 28)) (gCast contains: letter)) ; King_s_Letter
						(if (gCurRoom script:)
							((gCurRoom script:) setScript: takeLetterScr)
						else
							(gCurRoom setScript: takeLetterScr)
						)
					)
					((not (IsFlag 152))
						(if (not (gCurRoom script:))
							(gCurRoom setScript: openWindowScr)
						else
							((gCurRoom script:) setScript: openWindowScr)
						)
					)
					(else
						(gMessager say: 45 7) ; "The window's already open."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rope of Feature
	(properties
		noun 50
	)
)

(instance bell of Feature
	(properties
		noun 49
	)
)

(instance barrel of Feature
	(properties
		noun 51
	)
)

(instance atticJunk of Feature
	(properties
		noun 57
	)
)

(instance letter of View
	(properties
		x 81
		y 86
		noun 60
		view 324
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(birdPeckScr dispose:)
				(gGame points: 318 1)
				(if (gCurRoom script:)
					((gCurRoom script:) setScript: takeLetterScr)
				else
					(gCurRoom setScript: takeLetterScr)
				)
			)
			(6 ; Look
				(= gDictionaryWord 83)
				(super doVerb: theVerb &rest)
			)
			(84 ; Trivia
				(= gDictionaryWord 71)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance crate1 of Feature
	(properties
		noun 52
	)
)

(instance crate2 of Feature
	(properties
		noun 53
	)
)

(instance crate3 of Feature
	(properties
		noun 54
	)
)

(instance crate4 of Feature
	(properties
		noun 55
	)
)

(instance lightningRod of Feature
	(properties
		noun 46
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windowView of View
	(properties
		x 66
		y 63
		view 325
		loop 3
	)

	(method (doVerb theVerb)
		(atticWindow doVerb: theVerb &rest)
	)
)

(instance openWindowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(atticWindow noun: 45)
				(gGame points: 316 1)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 98 124 self
				)
			)
			(2
				(if (not (IsFlag 78))
					(gMessager say: 44 7 18 0 self) ; "Pepper decides to open the window for some fresh air."
				else
					(gMessager say: 44 7 0 1 self) ; "Let me open this window for you, little guy."
				)
			)
			(3
				(windowView dispose:)
				((ScriptID 895 0) ; pepper
					view: 325
					setLoop: 1
					cel: 0
					posn: 98 124
					setSpeed: 8
					setCycle: End self
				)
				(gLongSong2 number: 917 setLoop: 1 play:)
			)
			(4
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: MoveTo 109 128 self
				)
			)
			(5
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(6
				(SetFlag 152)
				(if (not (IsFlag 78))
					((ScriptID 895 0) normalize:) ; pepper
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(7
				((ScriptID 895 0) normalize: setSpeed: local1) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance leaveRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 48 7 0 0 self) ; "I guess I'll go back down..."
			)
			(2
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 187 143 self
				)
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(gCurRoom newRoom: 320)
				(self dispose:)
			)
		)
	)
)

