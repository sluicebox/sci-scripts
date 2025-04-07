;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use OccCyc)
(use sBurnBabyBurn)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 8
	local5 = 1
	local6
)

(instance rm260 of GloryRm
	(properties
		picture 260
		horizon 103
		north 250
		east 280
		south 270
	)

	(method (init)
		(= local2
			(cond
				(
					(and
						(not
							(or
								(IsFlag 37)
								(IsFlag 41)
								(IsFlag 38)
								(IsFlag 39)
								(IsFlag 48)
							)
						)
						(not (IsFlag 30))
					)
					1
				)
				(
					(and
						(not (IsFlag 37))
						(not (IsFlag 48))
						(IsFlag 30)
						(IsFlag 47)
						(>= gDay 5)
						(!= gPrevRoomNum 250)
					)
					4
				)
				(
					(and
						(not
							(or
								(IsFlag 45)
								(IsFlag 37)
								(IsFlag 41)
								(IsFlag 38)
								(IsFlag 39)
								(IsFlag 48)
							)
						)
						(IsFlag 30)
						(not (IsFlag 47))
					)
					2
				)
				(
					(and
						(not
							(or
								(IsFlag 45)
								(IsFlag 37)
								(IsFlag 41)
								(IsFlag 38)
								(IsFlag 39)
								(IsFlag 48)
							)
						)
						(IsFlag 30)
						(IsFlag 47)
					)
					3
				)
				((and (IsFlag 38) (not (IsFlag 39))) 5)
				((and (or (IsFlag 48) (IsFlag 39)) (not (IsFlag 40))) 6)
				((and (IsFlag 37) (not (IsFlag 40)) (>= gDay 5)) 7)
				((and (IsFlag 41) (not (IsFlag 42))) 8)
				((and (IsFlag 43) (not (IsFlag 44))) 9)
				((and (IsFlag 45) (not (IsFlag 49))) 10)
				((IsFlag 40) 11)
				((and (IsFlag 30) (IsFlag 47)) 3)
				(else 3)
			)
		)
		(if (not (OneOf gPrevRoomNum 250 280))
			(gLongSong number: 250 setLoop: -1 play:)
		)
		(gEgo init: normalize:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 84 9 84 9 177 63 177 63 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 158 252 158 252 149 287 149 287 146 223 146 223 141 215 141 215 145 192 145 180 138 180 129 97 127 97 120 78 120 78 117 44 117 44 107 17 98 17 0 319 0
					yourself:
				)
		)
		(self
			addPoly:
				((Polygon new:) init: 0 98 31 98 58 111 0 111 yourself:)
				50
				((Polygon new:) init: 146 139 239 178 132 187 12 122 yourself:)
				120
		)
		(if (and (OneOf local2 4 7) (<= gTime 3))
			(hans init: approachVerbs: 4 2) ; Do, Talk
			(franz init: approachVerbs: 4 2) ; Do, Talk
			(ivan init: approachVerbs: 4 2 setScript: sGroupTalk) ; Do, Talk
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 191 170 151 170 151 166 85 166 85 153 178 153
						yourself:
					)
			)
		)
		(if (and (>= gTime 4) (not (gCast contains: hans)))
			(ClearFlag 266)
			(closedWin init: approachVerbs: 4 80 42 28) ; Do, openSpell, theToolkit, theLockpick
		else
			(SetFlag 266)
			(burgoWin init: approachVerbs: 4) ; Do
		)
		(if (== local2 5)
			(proc87_0)
		else
			(barrel init: approachVerbs: 4 24) ; Do, theFlask
			(innSign init: approachVerbs: 4) ; Do
			(storeSign init: approachVerbs: 4) ; Do
			(burgoSign init: approachVerbs: 4) ; Do
			(innWindow init:)
			(storeWindow init: approachVerbs: 4) ; Do
			(innHighWin init: approachVerbs: 4) ; Do
			(burgoHighWin1 init: approachVerbs: 4) ; Do
			(burgoHighWin2 init: approachVerbs: 4) ; Do
			(archWay init:)
			(tree1 init:)
			(tree2 init:)
		)
		(if gNight
			(lamp1 init:)
			(lamp2 init:)
		)
		(innDoor init: approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(storeDoor init: approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(burgoDoor init: approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(if
			(or
				(and (<= 0 gTime 3) (not (IsFlag 32)))
				(and (<= gTime 3) (IsFlag 38) (IsFlag 39))
				(gCast contains: hans)
			)
			(burgoMeister init: approachVerbs: 4 2 setScript: sBurgoGibber) ; Do, Talk
		)
		(((ScriptID 6 0) new:) ; eFeatureR
			x: 28
			y: 49
			nsLeft: 0
			nsTop: 1
			nsBottom: 98
			nsRight: 56
			approachX: 15
			approachY: (gCurRoom horizon:)
			init:
		)
		(switch gPrevRoomNum
			(250
				(gEgo posn: 18 102 setScaler: Scaler 122 50 189 87)
				(= local0 34)
				(= local1 126)
			)
			(270
				(gEgo posn: 265 240 setScaler: Scaler 122 50 189 87)
				(= local0 224)
				(= local1 181)
			)
			(280
				(gEgo setScaler: Scaler 122 50 189 87 x: 312 y: 180)
				(= local0 (- (gEgo x:) 20))
				(= local1 (gEgo y:))
			)
			(300
				(gEgo setScaler: Scaler 122 50 189 87)
				(if (IsFlag 70)
					(closedWin hide:)
					(gEgo view: 352 loop: 0 cel: 10 x: 271 y: 148)
				else
					(gEgo loop: 2 posn: 222 136 setPri: -1)
					(burgoDoor cel: 8)
				)
			)
			(310
				(gEgo
					loop: 2
					posn: 180 119
					setScaler: Scaler 122 50 189 87
					setPri: 0
				)
			)
			(320
				(gEgo
					loop: 2
					posn: 76 111
					setScaler: Scaler 122 50 189 87
					setPri: 0
				)
			)
			(330
				(if (IsFlag 70)
					(gEgo
						loop: 2
						posn: 77 132
						setScaler: Scaler 122 50 189 87
					)
				else
					(= local6 (gEgo cycleSpeed:))
					(gEgo
						view: 7
						setLoop: 3 1
						cel: 0
						posn: 100 107
						setScaler: Scaler 122 72 189 122
						setSpeed: 15
						setCycle: Walk
					)
				)
			)
			(else
				(gEgo setScaler: Scaler 122 50 189 87 posn: 160 160)
			)
		)
		(if (gCast contains: burgoMeister)
			(heroTeller
				init:
					gEgo
					260
					18
					128
					(switch local2
						(1 22)
						(4 33)
						(2 23)
						(3 24)
						(6 26)
						(7 32)
						(8 28)
						(9 29)
						(10 30)
						(11 31)
					)
			)
		)
		(super init: &rest)
		(cond
			((OneOf gPrevRoomNum 250 270 280)
				(self setScript: sEnterScr)
			)
			((== gPrevRoomNum 300)
				(if (IsFlag 70)
					(gEgo setScript: sOutBurgoWin)
				else
					(gEgo setScript: sOutBurgoDoor)
				)
			)
			((== gPrevRoomNum 310)
				(gEgo setScript: sOutStoreDoor)
			)
			((== gPrevRoomNum 320)
				(gEgo setScript: sOutInnDoor)
			)
			((== gPrevRoomNum 330)
				(if (IsFlag 70)
					(ClearFlag 70)
					(gGlory handsOn:)
				else
					(gEgo setScript: sClimbDownInnWin)
				)
			)
			(else
				(gGlory handsOn:)
			)
		)
	)

	(method (doit)
		(if (and (!= local4 gTime) (not (gCurRoom script:)) local5)
			(cond
				((<= gTime 3)
					(if (OneOf local4 7 8)
						(if (innDoor actions:)
							((innDoor actions:) dispose:)
							(innDoor actions: 0)
							(storeDoor actions: 0)
							(burgoDoor actions: 0)
						)
						(if (innDoor heading:)
							((innDoor heading:) dispose:)
							(innDoor heading: 0)
						)
						(if (burgoDoor heading:)
							((burgoDoor heading:) dispose:)
							(burgoDoor heading: 0)
						)
						(if (storeDoor heading:)
							((storeDoor heading:) dispose:)
							(storeDoor heading: 0)
						)
						(if (and (not (gCast contains: hans)) (== local4 7))
							(gCurRoom setScript: sOpenWindow)
						)
						(innDoor
							heading:
								(((ScriptID 49 0) new:) ; doorMat
									init:
										((Polygon new:)
											type: PNearestAccess
											init: 62 114 93 116 80 124 56 120
											yourself:
										)
										7
										3
										6
										sInInnDoor
									yourself:
								)
						)
						(burgoDoor
							heading:
								(((ScriptID 49 0) new:) ; doorMat
									init:
										((Polygon new:)
											type: PNearestAccess
											init: 207 139 235 139 233 146 205 144
											yourself:
										)
										7
										3
										6
										sInBurgoDoor
									yourself:
								)
						)
						(storeDoor
							heading:
								(((ScriptID 49 0) new:) ; doorMat
									init:
										((Polygon new:)
											type: PNearestAccess
											init: 165 127 187 127 177 137 161 133
											yourself:
										)
										7
										3
										6
										sInStoreDoor
									yourself:
								)
						)
					)
				)
				((<= gTime 5)
					(if (OneOf local4 3 8)
						(if (innDoor heading:)
							((innDoor heading:) dispose:)
							(innDoor heading: 0)
							(storeDoor actions: 0)
							(burgoDoor actions: 0)
						)
						(if (burgoDoor heading:)
							((burgoDoor heading:) dispose:)
							(burgoDoor heading: 0)
						)
						(if (storeDoor heading:)
							((storeDoor heading:) dispose:)
							(storeDoor heading: 0)
						)
						(if (innDoor actions:)
							((innDoor actions:) dispose:)
							(innDoor actions: 0)
						)
						(if (and (not (gCast contains: hans)) (== local4 3))
							(gCurRoom setScript: sCloseWindow)
						)
						(innDoorTeller init: innDoor 260 18 129 17)
					)
				)
				((and (<= gTime 7) (OneOf local4 5 8))
					(if (innDoor actions:)
						((innDoor actions:) dispose:)
						(innDoor actions: 0)
					)
					(innDoorTeller init: innDoor 260 18 129 19)
					(burgoDoor actions: innDoorTeller)
					(storeDoor actions: innDoorTeller)
				)
			)
			(= local4 gTime)
		)
		(if (and (== (gCurRoom script:) (ScriptID 31 1)) (>= (gEgo z:) 40)) ; sLevitate
			(gCurRoom setScript: sLevitateIntoInn)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				(if (and (>= gTime 4) (not (gCast contains: hans)))
					((ScriptID 31 0) init: 69 123 83 0 2) ; leviCode
				else
					(gMessager say: 16 6 65) ; "Somebody might see you during the day!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 320 310 300 270)
			(gLongSong fade: 0)
		)
		(if
			(and
				(OneOf newRoomNumber 250 270 280 310 320 330)
				(not (== gTime 0))
				(not (== local4 7))
				(not (>= gTime 6))
			)
			(SetFlag 32)
		)
		(super newRoom: newRoomNumber 1 &rest)
	)

	(method (dispose)
		(if (innDoor heading:)
			((innDoor heading:) dispose:)
		)
		(if (burgoDoor heading:)
			((burgoDoor heading:) dispose:)
		)
		(if (storeDoor heading:)
			((storeDoor heading:) dispose:)
		)
		(if (innDoor actions:)
			((innDoor actions:) dispose:)
		)
		(if (burgoDoor actions:)
			((burgoDoor actions:) dispose:)
		)
		(if (storeDoor actions:)
			((storeDoor actions:) dispose:)
		)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(1
				(if (and (<= gTime 3) (IsFlag 38) (IsFlag 39))
					(gCurRoom setScript: sHeroGuilty)
				else
					(= cycles 1)
				)
			)
			(2
				(if
					(and
						(gCast contains: burgoMeister)
						(IsFlag 115)
						(not (IsFlag 311))
					)
					(SetFlag 311)
					(gMessager say: 11 6 118 0 self) ; "You have brought real joy to Mordavia by bringing Tanya back. When she was stolen, it was as if all the laughter here had been taken as well. You gave us back our happiness."
				else
					(= ticks 1)
				)
			)
			(3
				(if (gCast contains: burgoMeister)
					(switch local2
						(1
							(SetFlag 30)
							(gMessager say: 11 6 21 0 self) ; "You! How did you get here? Why are you here?"
						)
						(2
							(SetFlag 47)
							(gMessager say: 11 6 22 0 self) ; "So you are still around, are you? When are you leaving Mordavia?"
						)
						(3
							(gMessager say: 11 6 24 0 self) ; "Still you remain. It is a wonder you have managed to live so long."
						)
						(4
							(SetFlag 37)
							(gMessager say: 11 6 25 0 self) ; "Look, he is safely locked away. We should wait a bit to see if the gravedigger shows up..."
						)
						(5
							(self setScript: (ScriptID 87 2)) ; sBurnBabyBurn
						)
						(6
							(if (IsFlag 48)
								(gMessager say: 11 6 27 0 self) ; "The Werewolf threat has ended."
							else
								(= cycles 1)
							)
						)
						(7
							(if (and (not (IsFlag 53)) (IsFlag 238))
								(SetFlag 53)
								(gMessager say: 21 6 31 0 self) ; "We should burn the gypsy now!"
							else
								(gMessager say: 11 6 32 0 self) ; "Calm down, everyone. Give me a little more time..."
							)
						)
						(8
							(SetFlag 42)
							(gMessager say: 11 6 33 0 self) ; "The strangest thing happened. Someone broke into the old monastery and burned the place down! I don't suppose you'd know anything about this?"
						)
						(9
							(SetFlag 44)
							(gMessager say: 11 6 34 0 self) ; "Thank you for returning my great-grandfather's sword. My family honor has at last been restored."
						)
						(10
							(SetFlag 49)
							(gMessager say: 11 6 35 0 self) ; "Nikolai has disappeared from his home. The last time I saw him, he said something about finding Anna. I fear he is dead."
						)
						(11
							(proc0_17 11 6 36 self)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (and (gCast contains: burgoMeister) (== local2 6))
					(cond
						((and (IsFlag 39) (not (IsFlag 48)))
							(SetFlag 384)
							(gMessager say: 11 6 28 0 self) ; "The gypsy escaped, and I hope we never see or hear of him again. I do not think he was guilty of anything other than being in the wrong place at the wrong time."
						)
						((and (not (IsFlag 39)) (IsFlag 48))
							(SetFlag 40)
							(SetFlag 39)
							(gMessager say: 11 6 30 0 self) ; "Since you have found and rescued Igor, I have released our gypsy prisoner. It seems he was not a Werewolf after all! All the peasant fears were for nothing."
						)
						((and (IsFlag 39) (IsFlag 48) (IsFlag 384))
							(SetFlag 40)
							(gMessager say: 11 6 126 0 self) ; "After the gypsy escaped, the townspeople again lived in terror of Werewolves. Thank you for rescuing Igor and calming the peasants' fears."
						)
						(else
							(SetFlag 40)
							(gMessager say: 11 6 29 0 self) ; "The gypsy escaped from his cell, but at least Igor returned to town. He has told us that you saved him from death."
						)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBurgoGibber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(burgoMeister
					loop: 0
					setCycle: OccCyc self 1 5 500 (Random 1 3) self
				)
			)
			(2
				(burgoMeister
					loop: 1
					setCycle: OccCyc self 1 5 500 (Random 1 3) self
				)
			)
			(3
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance sInInnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 0)
				(gEgo setMotion: PolyPath 76 121 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gLongSong2 number: 960 loop: 1 play:)
				(innDoor setCycle: End self)
			)
			(3
				(gEgo setPri: 0 setMotion: MoveTo 76 111 self)
			)
			(4
				(innDoor cycleSpeed: 4 setCycle: Beg self)
			)
			(5
				(if (and (>= gTime 4) (gCast contains: hans))
					(SetFlag 70)
				)
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 3)
			)
			(6
				(gGlory handsOn:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sOutInnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong2 number: 960 loop: 1 play:)
				(innDoor setCycle: End self)
			)
			(1
				(gEgo setPri: -1 setMotion: MoveTo 76 121 self)
			)
			(2
				(innDoor cycleSpeed: 4 setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 961 loop: 1 play:)
				(= local0 76)
				(= local1 130)
				(= next sEnterScr)
				(= seconds 2)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInStoreDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 0)
				(gEgo setMotion: PolyPath 180 129 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gLongSong2 number: 960 loop: 1 play:)
				(storeDoor setCycle: End self)
			)
			(3
				(gEgo setPri: 0 setMotion: MoveTo 180 119 self)
			)
			(4
				(storeDoor cycleSpeed: 4 setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 3)
			)
			(6
				(gGlory handsOn:)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance sOutStoreDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong2 number: 960 loop: 1 play:)
				(storeDoor setCycle: End self)
			)
			(1
				(gEgo setPri: -1 setMotion: MoveTo 180 129 self)
			)
			(2
				(storeDoor cycleSpeed: 4 setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 961 loop: 1 play:)
				(if (gCast contains: hans)
					(= next sEnterScr)
					(= local0 180)
					(= local1 139)
				)
				(= seconds 2)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInBurgoDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 0)
				(gEgo setHeading: 0 self)
			)
			(1
				(gLongSong2 number: 960 loop: 1 play:)
				(burgoDoor setCycle: End self)
			)
			(2
				(gEgo setPri: 0 setMotion: MoveTo 222 136 self)
			)
			(3
				(gGlory handsOn:)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance sOutBurgoDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 222 146 self)
			)
			(1
				(burgoDoor cycleSpeed: 4 setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 961 loop: 1 play:)
				(if (gCast contains: hans)
					(= next sEnterScr)
					(= local0 222)
					(= local1 153)
				)
				(= seconds 2)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInBurgoWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local6 (gEgo cycleSpeed:))
				(SetFlag 70)
				(gEgo
					view: 352
					loop: 0
					cel: 0
					setSpeed: 8
					posn: 271 148
					setCycle: End self
				)
			)
			(1
				(gEgo setSpeed: local6)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance sOutBurgoWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 70)
				(= local6 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 9 setCycle: Beg self)
			)
			(1
				(closedWin show:)
				(gMessager say: 16 6 125 0 self) ; "You close and lock the window behind you to avoid arousing suspicion."
			)
			(2
				(gEgo
					normalize: 3
					x: 269
					y: 149
					cycleSpeed: local6
					setMotion: MoveTo 230 157 self
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKnockOnInnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 0)
				(gMessager say: 18 129 9 0 self) ; "You hear movement on the other side of the door."
			)
			(1
				(gGlory handsOn:)
				(self setScript: sInInnDoor)
			)
		)
	)
)

(instance sClimbUpInnWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 70)
				(if register
					(gEgo setMotion: PolyPath 11 132 self)
				else
					(gEgo setMotion: PolyPath 99 121 self)
				)
			)
			(1
				(if register
					(gEgo trySkill: 11 100) ; climbing
					(Face gEgo (innDoor x:) (innDoor y:) self)
				else
					(= local6 (gEgo cycleSpeed:))
					(gEgo
						view: 7
						loop: 3
						cel: 0
						posn: 100 121
						cycleSpeed: 9
						setScaler: Scaler 122 73 189 119
						setCycle: CT 2 1 self
					)
				)
			)
			(2
				(if register
					(gEgo view: 8 loop: 0 cel: 0 setCycle: End self)
				else
					(gEgo posn: 100 118 setCycle: End self)
				)
			)
			(3
				(if register
					(gMessager say: 8 33 2 0 self) ; "Using your rope and grapnel, you climb up to the inn window."
				else
					(gEgo posn: 100 116 cel: 0)
					(= cycles 2)
				)
			)
			(4
				(if (not register)
					(gEgo cycleSpeed: local6)
				)
				(= cycles 3)
			)
			(5
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance sClimbDownInnWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 100 120 self)
			)
			(1
				(gEgo
					setSpeed: local6
					posn: 98 120
					setScaler: Scaler 122 50 189 87
					normalize: 3
				)
				(= cycles 2)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(if (and (== gHeroType 2) (not (IsFlag 505))) ; Thief
					(gEgo solvePuzzle: 505 2 4)
				)
				(gEgo setMotion: MoveTo 98 129 self)
			)
			(4
				(gGlory handsOn:)
				(self dispose: &rest)
			)
		)
	)
)

(instance sLevitateIntoInn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 70)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance sToolkitOnWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 37 42 19 0 self) ; "You attempt to pick the lock on the Burgomeister's window."
			)
			(1
				(if (== (gEgo trySkill: 9 250) 1) ; pick locks
					(SetFlag 266)
					(closedWin hide:)
					(gCurRoom setScript: sInBurgoWin)
				else
					(gMessager say: 37 42 20 0 self) ; "You'll need some more practice at this. The lock is apparently one of those modern, complicated types."
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(closedWin dispose:)
				(burgoMeister
					view: 261
					loop: 1
					cel: 11
					x: 273
					y: 130
					init:
					setCycle: Beg self
				)
			)
			(1
				(heroTeller
					init:
						gEgo
						260
						18
						128
						(switch local2
							(1 22)
							(2 23)
							(4 33)
							(3 24)
							(6 26)
							(7 32)
							(8 28)
							(9 29)
							(10 30)
							(11 31)
						)
				)
				(SetFlag 266)
				(burgoWin init: approachVerbs: 4) ; Do
				(burgoMeister
					view: 307
					x: 273
					y: 150
					approachVerbs: 4 2 ; Do, Talk
					setScript: sBurgoGibber
				)
				(= cycles 1)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (IsFlag 32)
					(burgoMeister
						setScript: 0
						view: 261
						loop: 0
						cel: 0
						x: 273
						y: 130
						init:
						setCycle: End self
					)
				else
					(burgoMeister setScript: 0)
					(= cycles 1)
				)
			)
			(1
				(burgoMeister
					view: 261
					loop: 1
					cel: 0
					x: 273
					y: 130
					setCycle: End self
				)
			)
			(2
				(if (gEgo actions:)
					((gEgo actions:) dispose:)
				)
				(ClearFlag 266)
				(closedWin init: approachVerbs: 4 80 42 28) ; Do, openSpell, theToolkit, theLockpick
				(burgoMeister dispose:)
				(= cycles 1)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenOnBurgoWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 266)
				(gMessager say: 37 80 0 0 self) ; "You hear a faint "Snick!" as the window responds to your Open spell."
			)
			(1
				(closedWin hide:)
				(gEgo setMotion: PolyPath 269 149 self)
			)
			(2
				(self setScript: sInBurgoWin)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGroupTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(self changeState: (Random 1 3))
			)
			(1
				1
				(hans setCycle: End self)
			)
			(2
				2
				(franz setCycle: End self)
			)
			(3
				3
				(ivan setCycle: End self)
			)
			(4
				4
				(= state -1)
				(= seconds (Random 3 12))
			)
		)
	)
)

(instance sHeroGuilty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 11 6 124 0 self) ; "You! Olga saw you leaving the office after the gypsy escaped. It seems you let him loose. It is a crime to aid and abet a criminal in Mordavia."
			)
			(1
				(EgoDead 124 0 0 0 912)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties)
)

(instance burgoTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 65 0)) ; burgoTalker
	)

	(method (showCases)
		(super
			showCases:
				82 ; Adventurers' Guild
				(and (OneOf local2 1 2 3) (not (IsFlag 183)))
				89 ; Old Man
				(not (IsFlag 49))
		)
	)

	(method (sayMessage)
		(if (== iconValue 82) ; Adventurers' Guild
			(gEgo get: 61) ; guild-key
			(SetFlag 183)
		)
		(super sayMessage: &rest)
	)
)

(instance hansTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 76 0)) ; hansTalker
	)

	(method (doVerb)
		(switch (CueObj client:)
			(hans
				(= talker (ScriptID 76 0)) ; hansTalker
			)
			(franz
				(= talker (ScriptID 77 0)) ; franzTalker
			)
			(ivan
				(= talker (ScriptID 78 0)) ; ivanTalker
			)
		)
		(super doVerb: &rest)
	)
)

(instance innDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 12 (or (gEgo has: 13) (gEgo has: 24))) ; Pick Lock, theLockpick, theToolkit
	)

	(method (sayMessage)
		(if (== iconValue 9) ; Knock on Door
			(self clean:)
			(gCurRoom setScript: sKnockOnInnDoor)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance closedWin of View
	(properties
		noun 37
		sightAngle 180
		x 273
		y 130
		priority 10
		fixPriority 1
		view 261
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_P)
			(= approachX 223)
			(= approachY 181)
		else
			(= approachX 269)
			(= approachY 149)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; theToolkit
				(gEgo setScript: sToolkitOnWin)
			)
			(80 ; openSpell
				(if (gEgo castSpell: 20)
					(= global441 272)
					(= global442 110)
					(gCurRoom setScript: (ScriptID 13 0) 0 self) ; castOpenScript
				)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenOnBurgoWin)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp1 of View
	(properties
		sightAngle 180
		x 192
		y 101
		priority 140
		fixPriority 1
		view 260
		loop 4
		signal 16384
	)
)

(instance lamp2 of View
	(properties
		sightAngle 180
		x 244
		y 99
		view 260
		loop 5
		signal 16384
	)
)

(instance burgoMeister of Prop
	(properties
		noun 11
		approachX 242
		approachY 146
		x 273
		y 150
		fixPriority 1
		view 307
		signal 16385
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(burgoTeller
			init:
				self
				260
				18
				131
				(switch local2
					(1 22)
					(2 23)
					(4 25)
					(3 24)
					(6 26)
					(7 27)
					(8 28)
					(9 29)
					(10 30)
					(else 31)
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; theSword
				(if (and (not (IsFlag 43)) (== ((gInventory at: 19) state:) 3)) ; theSword
					(gMessager say: 11 6 34) ; "Thank you for returning my great-grandfather's sword. My family honor has at last been restored."
				else
					(super doVerb: &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hans of Prop
	(properties
		approachX 134
		approachY 174
		x 121
		y 164
		view 264
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(hansTeller
			init:
				self
				260
				18
				132
				(switch local2
					(4 34)
					(7 35)
				)
		)
	)
)

(instance franz of Prop
	(properties
		approachX 134
		approachY 174
		x 163
		y 168
		view 264
		loop 1
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions hansTeller)
	)
)

(instance ivan of Prop
	(properties
		approachX 134
		approachY 174
		x 148
		y 160
		view 264
		loop 2
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions hansTeller)
	)
)

(instance innDoor of Prop
	(properties
		noun 2
		sightAngle 180
		x 84
		y 116
		priority 1
		fixPriority 1
		view 260
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(42 ; theToolkit
				(if (> gTime 5)
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(28 ; theLockpick
				(if (> gTime 5)
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(80 ; openSpell
				(if gNight
					(gMessager say: 2 80 2) ; "The lock "clicks," but you still can't open the door. It must be barred on the other side."
				else
					(gMessager say: 2 80 1) ; "That's overkill. Try the handle."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance storeDoor of Prop
	(properties
		noun 3
		sightAngle 180
		x 185
		y 126
		priority 1
		fixPriority 1
		view 260
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf gTime 4 5)
					(gMessager say: 3 4 2) ; "The General Store has closed for the evening."
				)
			)
			(42 ; theToolkit
				(if (> gTime 5)
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(28 ; theLockpick
				(if (> gTime 5)
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(80 ; openSpell
				(if gNight
					(gMessager say: 3 80 2) ; "The lock "clicks," but you still can't open the door. It must be barred on the other side."
				else
					(gMessager say: 3 80 1) ; "That's overkill. Try the handle."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance burgoDoor of Prop
	(properties
		noun 4
		sightAngle 180
		approachX 223
		approachY 141
		x 232
		y 134
		priority 1
		fixPriority 1
		view 260
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf gTime 4 5)
					(gMessager say: 4 4 2) ; "The Burgomeister's office is closed. A sign says "Office Hours 8 a.m. to 5 p.m.""
				)
			)
			(42 ; theToolkit
				(if gNight
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(28 ; theLockpick
				(if gNight
					(gMessager say: 2 28 2) ; "While the lock doesn't seem very complicated, your tools can't do much about the deadbolt and bar on the inside of the door."
				else
					(gMessager say: 2 28 1) ; "Rule #1 in your Famous Thieves' Correspondence Handbook was "Don't Get Caught!" Using thief tools here in broad daylight would be a good way to flunk out."
				)
			)
			(80 ; openSpell
				(if gNight
					(gMessager say: 4 80 2) ; "The lock "clicks," but you still can't open the door. It must be barred on the other side."
				else
					(gMessager say: 4 80 1) ; "That's overkill. Try the handle."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barrel of Feature
	(properties
		noun 1
		nsTop 167
		nsRight 53
		nsBottom 189
		sightAngle 180
		approachX 22
		approachY 177
		x 26
		y 178
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; theFlask
				(gEgo drop: 9 1 get: 10 1) ; theFlask, theWater
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance innSign of Feature
	(properties
		noun 5
		nsLeft 36
		nsTop 33
		nsRight 58
		nsBottom 54
		sightAngle 180
		x 47
		y 143
		z 100
	)
)

(instance storeSign of Feature
	(properties
		noun 6
		nsLeft 91
		nsTop 50
		nsRight 117
		nsBottom 75
		sightAngle 180
		x 104
		y 62
	)
)

(instance burgoSign of Feature
	(properties
		noun 7
		nsLeft 134
		nsTop 36
		nsRight 162
		nsBottom 63
		sightAngle 180
		x 148
		y 149
		z 100
	)
)

(instance innWindow of Feature
	(properties
		noun 8
		nsLeft 63
		nsTop 29
		nsRight 81
		nsBottom 58
		sightAngle 180
		x 72
		y 43
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(if (== (gEgo trySkill: 11 225) 1) ; climbing
						(gCurRoom setScript: sClimbUpInnWin)
					else
						(gMessager say: 16 6 13) ; "You're getting some good climbing practice; you need more."
					)
				else
					(gMessager say: 16 6 66) ; "Somebody might see you during the day!"
				)
			)
			(33 ; theGrapnel
				(if gNight
					(gCurRoom setScript: sClimbUpInnWin 0 1)
				else
					(gMessager say: 16 6 66) ; "Somebody might see you during the day!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance storeWindow of Feature
	(properties
		noun 9
		nsLeft 115
		nsTop 85
		nsRight 157
		nsBottom 115
		sightAngle 180
		x 136
		y 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 9 1 2) ; "It's completely dark inside; you can't see a thing."
				else
					(gMessager say: 9 1 1) ; "This is a well-stocked country store. Various foodstuffs and useful items adorn the shelves."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance innHighWin of Feature
	(properties
		noun 10
		nsLeft 119
		nsTop 45
		nsRight 155
		nsBottom 75
		sightAngle 180
		x 137
		y 60
	)
)

(instance burgoWin of Feature
	(properties
		noun 12
		nsLeft 251
		nsTop 86
		nsRight 294
		nsBottom 129
		sightAngle 180
		approachX 269
		approachY 149
		x 272
		y 107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (<= 0 gTime 3) (not (IsFlag 32)))
					(burgoMeister doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(42 ; theToolkit
				(gMessager say: 12 42 68) ; "The Burgomeister's window is already open."
			)
			(80 ; openSpell
				(gMessager say: 12 42 68) ; "The Burgomeister's window is already open."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance burgoHighWin1 of Feature
	(properties
		noun 13
		nsLeft 173
		nsTop 29
		nsRight 214
		nsBottom 63
		sightAngle 180
		x 193
		y 46
	)
)

(instance burgoHighWin2 of Feature
	(properties
		noun 13
		nsLeft 232
		nsTop 30
		nsRight 280
		nsBottom 59
		sightAngle 180
		x 256
		y 44
	)
)

(instance archWay of Feature
	(properties
		noun 14
		nsTop 47
		nsRight 58
		nsBottom 112
		sightAngle 180
		x 29
		y 79
	)
)

(instance tree1 of Feature
	(properties
		noun 15
		nsLeft 148
		nsTop 2
		nsRight 318
		nsBottom 55
		sightAngle 180
		x 233
		y 28
	)
)

(instance tree2 of Feature
	(properties
		noun 15
		nsLeft 288
		nsTop 56
		nsRight 319
		nsBottom 154
		sightAngle 180
		x 310
		y 105
	)
)

