;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0
	local1
)

(instance rm340 of LarryRoom
	(properties
		noun 1
		picture 340
		horizon 0
		north 350
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 48 139 42 167 85 167 104 150 118 104 136 82 108 82 115 93 92 100 47 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 266 119 248 112 266 105 304 114 314 129 305 134 289 132 278 122 267 119
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 69 319 120 286 100 244 93 203 95 199 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 159 80 183 80 208 137 159 137
					yourself:
				)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 350)
			(gGlobalSound1 number: 310 play: setLoop: -1 setVol: 95)
		)
		(gEgo
			init:
			normalize:
			actions: egoActions
			setScale: Scaler 100 76 129 77
		)
		(showerDoor init: approachVerbs: 3) ; Walk
		(larryLocker init: setCel: (if (IsFlag 47) 4 else 0) stopUpd:)
		(girlLocker init: stopUpd:)
		(lamps init:)
		(rightSide init:)
		(cond
			((Random 0 1)
				(girl1 init: ignoreActors: 1)
			)
			((Random 0 1)
				(girl2
					init:
					ignoreActors: 1
					stopUpd:
					setScale: Scaler 100 75 100 90
					setScript: babeLeaves
				)
			)
			((Random 0 1)
				(showerGirl init: cycleSpeed: 12 setScript: girlShowers)
			)
			(else
				(girl1 init: setScript: babeEnters)
			)
		)
		(dirtyPoster init: approachVerbs: 4) ; Do
		(dirtyTowel init: addToPic:)
		((dirtyTowel new:) setLoop: 1 x: 242 y: 124 init: addToPic:)
		((dirtyTowel new:) setLoop: 2 x: 196 y: 121 init: addToPic:)
		((dirtyTowel new:) setLoop: 3 x: 163 y: 131 init: addToPic:)
		((dirtyTowel new:) setLoop: 4 x: 268 y: 110 init: addToPic:)
		(lockers init:)
		(garbageCan init: approachVerbs: 4) ; Do
		(gWalkHandler addToFront: showerDoor)
		(switch gPrevRoomNum
			(310
				(gEgo posn: 86 158)
				(gCurRoom setScript: enterFromLobby)
			)
			(350
				(gEgo posn: 125 87)
				(gCurRoom setScript: enterFromShower)
			)
			(else
				(gEgo posn: 125 87)
				(gCurRoom setScript: enterFromLobby)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(= temp0 (gEgo edgeHit:))
		(= temp1 (gEgo y:))
		(cond
			(script)
			((== temp0 3)
				(if (not (OneOf (gEgo view:) 0 900))
					(gMessager say: 7 0 3) ; "La Costa Lotta does not permit its guests to walk about the resort wearing nothing but a towel."
					(self setScript: enterFromLobby)
				else
					(gCurRoom setScript: toSpaLobby)
				)
			)
			((< temp1 87)
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 350)
			)
		)
		(cond
			(
				(and
					(== (gEgo view:) 900)
					(gEgo mover:)
					(== (gEgo cel:) 4)
				)
				(if (== local1 0)
					(= local1 1)
					(sFx number: 346 loop: 1 play:)
				)
			)
			(
				(and
					(== (gEgo view:) 900)
					(gEgo mover:)
					(== (gEgo cel:) 1)
					(== local1 1)
				)
				(= local1 0)
				(sFx number: 347 loop: 1 play:)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: showerDoor)
		(super dispose:)
	)
)

(instance girlShowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(showerGirl setCycle: CT (Random 1 9) 1 self)
			)
			(1
				(= ticks (Random 30 120))
			)
			(2
				(showerGirl setCycle: Beg self)
			)
			(3
				(= ticks (Random 90 180))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance openLocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 106 self)
			)
			(1
				(gGame changeScore: 4 189)
				(= local0 (gEgo view:))
				(gEgo
					loop: (if (== (gEgo view:) 353) 1 else 0)
					view: 342
					setCel: 0
					setSpeed: 12
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(sFx number: 343 loop: 1 play:)
				(= ticks 30)
			)
			(3
				(gEgo setCycle: CT 3 -1 self)
			)
			(4
				(sFx number: 343 loop: 1 play:)
				(= ticks 30)
			)
			(5
				(gEgo setSpeed: 12 setCycle: CT 5 1 self)
			)
			(6
				(sFx number: 343 loop: 1 play:)
				(= ticks 30)
			)
			(7
				(gEgo setCycle: Beg self)
				(sFx number: 344 loop: 1 play:)
			)
			(8
				(larryLocker cel: 0 setCycle: End)
				(gEgo normalize: local0 1 1 setScale: Scaler 100 76 129 88)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeLocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 106 self)
			)
			(1
				(= local0 (gEgo view:))
				(larryLocker setCycle: Beg self)
				(gEgo
					loop: (if (== (gEgo view:) 353) 1 else 0)
					view: 342
					setCel: 5
					setSpeed: 12
					setScale: 0
					setCycle: Beg
				)
			)
			(2
				(sFx number: 345 loop: 1 play:)
				(gEgo normalize: local0 1 1 setScale: Scaler 100 76 129 88)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toSpaLobby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound1 fade: 127 10 5 0)
				(gEgo setMotion: MoveTo (gEgo x:) 185 self)
			)
			(1
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance enterFromLobby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 102 135 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 118 100 self)
			)
			(1
				(gEgo normalize: (gEgo view:) 2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance babeLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(girl2 setCycle: Beg self)
			)
			(2
				(girl2
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 196 84 self
				)
			)
			(3
				(girl2 setPri: 0 setMotion: PolyPath 212 84 self)
			)
			(4
				(if (gCast contains: girl1)
					(girl1 setScript: babeEnters)
				)
				(girl2 setPri: -1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance babeEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 25))
			)
			(1
				(girl2
					x: 196
					y: 84
					init:
					setScale: Scaler 100 75 100 90
					setCycle: Walk
					setMotion: PolyPath 233 97 self
				)
			)
			(2
				(girlLocker dispose:)
				(girl2
					setScale: 0
					view: 344
					posn: 263 70
					loop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(girl2 loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(= seconds 5)
			)
			(5
				(girl2 loop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(= seconds 2)
			)
			(7
				(girlLocker init: stopUpd:)
				(girl2
					view: 341
					setScale: Scaler 100 75 100 90
					posn: 235 98
					setCycle: Walk
					setMotion: PolyPath 257 118 self
				)
			)
			(8
				(girl2 setMotion: MoveTo 257 118 self)
			)
			(9
				(girl2 loop: 5 setCel: 0 setCycle: End self)
			)
			(10
				(girl2 setScript: babeLeaves)
				(self dispose:)
			)
		)
	)
)

(instance wearTowel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 82 106 self)
			)
			(1
				(gEgo setMotion: MoveTo 75 106 self)
			)
			(2
				(gEgo
					view: 342
					setSpeed: 12
					setScale: 0
					loop: 2
					setPri: 0
					setCel: 0
					setCycle: End self
				)
				(sFx number: 234 loop: -1 play:)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo loop: 3 setCel: 0 setCycle: End self)
			)
			(5
				(sFx stop:)
				(= ticks 30)
			)
			(6
				(gEgo loop: 4 setCel: 0 setCycle: End self)
			)
			(7
				(= ticks 30)
			)
			(8
				(sFx stop:)
				(= ticks 30)
			)
			(9
				(gInventory eachElementDo: #perform dropInv)
				(gEgo get: 38) ; towel
				(gGame changeScore: 6 190)
				(= ticks 30)
			)
			(10
				(gEgo
					view: 353
					setLoop: 1
					setCycle: Rev
					setScale: Scaler 100 76 129 88
					setPri: -1
					setMotion: MoveTo 83 106 self
				)
			)
			(11
				(larryLocker setCycle: Beg self)
			)
			(12
				(sFx number: 345 loop: 1 play:)
				(ClearFlag 47)
				(gEgo normalize: 353 1 1)
				(SetFlag 74)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getDressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 82 106 self)
			)
			(1
				(gEgo setMotion: MoveTo 75 106 self)
			)
			(2
				(gEgo
					view: 342
					setSpeed: 12
					loop: 4
					setCel: 4
					setScale: 0
					setPri: 0
					setCycle: Beg self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(sFx number: 234 loop: -1 play:)
				(gEgo loop: 3 setCel: 14 setCycle: Beg self)
			)
			(5
				(= ticks 30)
			)
			(6
				(gEgo view: 342 loop: 2 setCel: 11 setCycle: Beg self)
			)
			(7
				(sFx stop:)
				(= ticks 30)
			)
			(8
				(sFx stop:)
				(gInventory eachElementDo: #perform getInv)
				(gEgo
					get: 38 ; towel
					view: 900
					setLoop: 1
					setPri: -1
					setCycle: Rev
					setScale: Scaler 100 76 129 88
					setMotion: MoveTo 85 106 self
				)
			)
			(9
				(larryLocker setCycle: Beg self)
			)
			(10
				(sFx number: 345 loop: 1 play:)
				(ClearFlag 47)
				(gEgo normalize: 900 1 1)
				(ClearFlag 74)
				(if (IsFlag 65)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(11
				(if (IsFlag 65)
					(ClearFlag 65)
					(gMessager say: 1 0 6 0 self) ; "Ahhh. A nice hot shower always makes me feel like a new man!"
				else
					(self cue:)
				)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance larryLocker of Prop
	(properties
		x 61
		y 79
		noun 6
		view 342
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(56 ; towel
				(cond
					((not (IsFlag 47))
						(cond
							((== (gEgo view:) 353)
								(gMessager say: 6 56 3) ; "It's tough to reach your leisure suit through those tiny slits in the locker door."
								(return 1)
							)
							((== (gEgo view:) 900)
								(super doVerb: theVerb)
							)
							(else
								(gMessager say: 6 56 1) ; "It's tough to reach your leisure suit through those tiny slits in the locker door."
								(return 1)
							)
						)
					)
					((== (gEgo view:) 900)
						(gCurRoom setScript: wearTowel)
					)
					((IsFlag 25)
						(if (== (gEgo view:) 353)
							(gMessager say: 7 0 2) ; "You can't leave the locker room smelling of sweat!"
						else
							(gMessager say: 7 0 1) ; "Gary will be "oh, so unhappy" if you slop mud all over his sweet new carpet."
						)
						(return 1)
					)
					(else
						(gCurRoom setScript: getDressed)
					)
				)
			)
			(4 ; Do
				(cond
					((== (gEgo view:) 351)
						(gMessager say: 6 4 1) ; "You wouldn't think of changing back into your leisure suit without taking a shower first!"
						(return 1)
					)
					((IsFlag 47)
						(ClearFlag 47)
						(gCurRoom setScript: closeLocker)
					)
					(else
						(SetFlag 47)
						(gCurRoom setScript: openLocker)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance girlLocker of View
	(properties
		x 263
		y 70
		view 340
		loop 6
	)
)

(instance dirtyTowel of View
	(properties
		x 214
		y 106
		view 340
		signal 16385
	)
)

(instance girl1 of Prop
	(properties
		x 169
		y 106
		view 345
		loop 1
		cycleSpeed 12
	)

	(method (doit)
		(if (and (not (self cycler:)) (== (Random 0 500) 50))
			(if (== (self cel:) 0)
				(self setCycle: CT (Random 1 5) 1)
			else
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance girl2 of Actor
	(properties
		x 257
		y 118
		view 341
		loop 5
		cel 5
	)
)

(instance showerGirl of Prop
	(properties
		x 200
		y 87
		view 345
		cel 5
	)

	(method (cue)
		(self setCycle: RandCycle 5)
	)
)

(instance lockers of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 30 76 45 71 98 56 106 49 106 11 120 10 123 0 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dirtyPoster of Feature
	(properties
		x 87
		y 90
		noun 4
		nsTop 59
		nsLeft 82
		nsBottom 72
		nsRight 93
		approachX 91
		approachY 107
	)
)

(instance garbageCan of Feature
	(properties
		noun 5
		approachX 91
		approachY 107
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 82 93 77 80 81 77 92 78 90 91 83 93
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance showerDoor of Feature
	(properties
		x 130
		y 20
		noun 2
		nsTop 44
		nsLeft 98
		nsBottom 96
		nsRight 137
		approachX 122
		approachY 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom newRoom: 350)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamps of Feature
	(properties
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 47 17 48 13 57 10 68 11 75 13 76 18 62 21 48 19
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightSide of Feature
	(properties
		x 160
		y 200
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 155 0 319 0 319 138 152 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(56 ; towel
				(cond
					((not (IsFlag 47))
						(if (== (gEgo view:) 900)
							(gMessager say: 7 56 5) ; "This is the right room in which to change clothes, but you have no locker in which to place your leisure suit. Find an unused locker."
						else
							(gMessager say: 7 56 3) ; "This looks like the room where you left your leisure suit but all these lockers are closed."
						)
						(return 1)
					)
					((IsFlag 25)
						(if (== (gEgo view:) 353)
							(gMessager say: 7 0 2) ; "You can't leave the locker room smelling of sweat!"
						else
							(gMessager say: 7 0 1) ; "Gary will be "oh, so unhappy" if you slop mud all over his sweet new carpet."
						)
						(return 1)
					)
					((== (gEgo view:) 353)
						(gCurRoom setScript: getDressed)
						(return 1)
					)
					(else
						(gCurRoom setScript: wearTowel)
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dropInv of Code
	(properties)

	(method (doit param1)
		(if (== (param1 owner:) gEgo)
			(param1 owner: 340)
		)
	)
)

(instance getInv of Code
	(properties)

	(method (doit param1)
		(if (== (param1 owner:) 340)
			(param1 owner: gEgo)
		)
	)
)

(instance sFx of Sound
	(properties)
)

