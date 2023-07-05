;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use OccCyc)
(use LarryRoom)
(use CycleBet)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm820 0
	rideTram 1
	takeABreak 2
	curtis 3
)

(local
	local0
	local1
	local2
)

(instance rm820 of LarryRoom
	(properties
		noun 1
		picture 820
		horizon 40
		north 230
		south 800
		west 690
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 75 0 90 153 95 178 90 192 99 208 139 218 139 197 94 292 88 277 71 151 75 121 67 87 39 80 39 88 51 100 73 90 77
					yourself:
				)
		)
		(super init: &rest)
		(gGlobalSound1 stop:)
		(gGlobalSound2 number: 820 play: setVol: 50 setLoop: -1 fade: 127 10 10 0)
		(cardSlot init: ignoreActors: 1 approachVerbs: 4 10) ; Do, badge
		(frontFlowers init:)
		(stairs init:)
		(otherStairs init:)
		(leftTree init:)
		(rightTree init:)
		(backFlowers init:)
		(if (and (!= gPrevRoomNum 830) (IsFlag 23))
			(= local1 1)
			(curtis x: 133 y: 93 view: 824 loop: 1 cel: 0 init: ignoreActors: 1)
			(thatOldTram init: ignoreActors: 1 setScript: tramFiddling)
			(gCurRoom
				addObstacle:
					(= local0
						((Polygon new:)
							type: PBarredAccess
							init: 39 83 107 82 152 84 152 92 40 89
							yourself:
						)
					)
			)
		)
		(switch gPrevRoomNum
			(230
				(self setScript: enterFromPool)
			)
			(690
				(if (IsFlag 35)
					((ScriptID 825 1) z: 0 view: 90 posn: 0 90 init:) ; tram
					(self setScript: rideTram)
				else
					(self setScript: enterFromHall)
				)
			)
			(840
				(self setScript: enterFromCamp)
			)
			(830
				(thatOldTram x: 75 y: 85 init:)
				(gEgo posn: 136 91 init: view: 85 loop: 2 setCel: 4)
				(self setScript: fromTramCU)
			)
			(else
				(self setScript: enterFromExterior)
			)
		)
	)

	(method (dispose)
		(if (gEgo has: 14) ; flashlight
			(ClearFlag 23)
		)
		(gGlobalSound2 fade:)
		(DisposeScript 64964)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 830)
			(ClearFlag 53)
			(ClearFlag 71)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo edgeHit:))
		(cond
			(script)
			((== temp0 1)
				(if (gEgo has: 14) ; flashlight
					(curtisTimer dispose:)
					(gCurRoom setScript: gimmeMyLight)
				else
					(gCurRoom newRoom: 230)
				)
			)
			((== temp0 3)
				(if (gEgo has: 14) ; flashlight
					(curtisTimer dispose:)
					(gCurRoom setScript: gimmeMyLight)
				else
					(gCurRoom setScript: exitSouth)
				)
			)
			((== temp0 4)
				(if (gEgo has: 14) ; flashlight
					(curtisTimer dispose:)
					(gCurRoom setScript: gimmeMyLight)
				else
					(gCurRoom newRoom: 690)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance gimmeMyLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 6 2 7 10 self) ; "Oh, hey! I almost forgot. I need my flashlight back!"
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 82 82 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gMessager sayRange: 6 2 7 11 14 self) ; "Here you go. That sure is a powerful flashlight."
			)
			(4
				(gMessager say: 5 0 4 0 self) ; "The tram is just leaving for Kingman, Barstow, Cucamonga, and all points west."
			)
			(5
				(gEgo put: 14) ; flashlight
				((gCurRoom obstacles:) delete: local0)
				(local0 dispose:)
				(thatOldTram dispose:)
				(ClearFlag 23)
				((ScriptID 825 1) init: setMotion: (ScriptID 825 0)) ; tram, theTramPath
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance exitWest of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance helpCurtis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (thatOldTram script:)
					((thatOldTram script:) dispose:)
				)
				(Face gEgo curtis self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager sayRange: 6 2 7 1 4 self) ; "Excuse me, sir. May I be of assistance?"
			)
			(3
				(curtis setCycle: 0)
				(gEgo setMotion: PolyPath 121 91 self)
			)
			(4
				(if (gCast contains: tramLid)
					(tramLid dispose:)
				)
				(curtis hide:)
				(gEgo
					view: 85
					posn: 136 91
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(5
				(gMessager sayRange: 6 2 7 5 7 self) ; "Does that help?"
			)
			(6
				(= seconds 5)
			)
			(7
				(gMessager say: 6 2 7 8 self) ; "THERE! Got it. Let's see if it works..."
			)
			(8
				(gEgo get: 14 posn: 121 91 normalize: 900 3) ; flashlight
				(gGame changeScore: 2 267)
				(curtis
					show:
					view: 824
					loop: 1
					setPri: 80
					setCel: 3
					setCycle: Beg self
				)
			)
			(9
				(curtis loop: 0 setCel: 4 cycleSpeed: 12 setCycle: Beg self)
			)
			(10
				(gGame handsOn:)
				(curtis
					view: 81
					setCycle: Walk
					cycleSpeed: 6
					setStep: 4 2
					setMotion: MoveTo 75 84 self
				)
			)
			(11
				(curtis dispose:)
				(thatOldTram view: 83 loop: 0 setCel: 0 setCycle: End self)
			)
			(12
				(thatOldTram loop: 2 setCel: 0 setCycle: End self)
			)
			(13
				(gMessager say: 6 2 7 9 self) ; "Hey. Good as new. Thanks for your help. Gotta be goin' now."
			)
			(14
				(curtisTimer setReal: curtis 15)
				(self dispose:)
			)
		)
	)
)

(instance curtisNTheTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(curtis x: 327 y: 82 init: ignoreActors: 1)
				(cardSlot setCycle: End self)
				(sFx number: 821 loop: 1 play:)
			)
			(1
				(gGame handsOn:)
				(curtis
					setCycle: Walk
					setStep: 6 2
					cycleSpeed: 9
					moveSpeed: 9
					setMotion: MoveTo 274 84 self
				)
			)
			(2
				(sFx number: 821 loop: 1 play:)
				(cardSlot setCycle: Beg)
				(curtis setMotion: MoveTo 132 84 self)
			)
			(3
				(curtis ignoreActors: 1 setMotion: MoveTo 74 84 self)
			)
			(4
				(curtis hide:)
				(thatOldTram view: 83 loop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(sFx number: 572 loop: 1 play:)
				(= ticks 30)
			)
			(6
				(thatOldTram loop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(sFx number: 572 loop: 1 play:)
				(= ticks 33)
			)
			(8
				(thatOldTram setCycle: Beg self)
			)
			(9
				(sFx number: 572 loop: 1 play:)
				(= ticks 40)
			)
			(10
				(thatOldTram setCycle: End self)
			)
			(11
				(sFx number: 572 loop: 1 play:)
				(= ticks 33)
			)
			(12
				(thatOldTram setCycle: Beg self)
			)
			(13
				(sFx number: 572 loop: 1 play:)
				(= ticks 60)
			)
			(14
				(thatOldTram setCycle: End self)
			)
			(15
				(sFx number: 572 loop: 1 play:)
				(= ticks 40)
			)
			(16
				(thatOldTram setCycle: Beg self)
			)
			(17
				(gMessager say: 0 0 12 1 self) ; "What the...?!"
			)
			(18
				(= ticks 20)
			)
			(19
				(thatOldTram loop: 0 setCel: 6 setCycle: Beg self)
			)
			(20
				(thatOldTram view: 80 ignoreActors: 1)
				(curtis
					show:
					setCycle: Walk
					setPri: 84
					setStep: 4 2
					ignoreActors: 1
					setMotion: MoveTo 133 93 self
				)
			)
			(21
				(gMessager say: 0 0 12 2 self) ; "(MUMBLING UNDER BREATH) Cod spam gone brefgth! Stupid tram."
			)
			(22
				(gCurRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 39 83 107 82 152 84 152 92 40 89
								yourself:
							)
						)
				)
				(curtis view: 824 loop: 0 setCel: 0 setCycle: End self)
				(= local1 1)
			)
			(23
				(= seconds 2)
			)
			(24
				(gMessager say: 0 0 12 3 self) ; "It's dark in there. Where's mah light?"
			)
			(25
				(curtis loop: 1 setCel: 0 setCycle: End self)
			)
			(26
				(= seconds 2)
			)
			(27
				(curtis loop: 2 setCel: 0 setCycle: End self)
			)
			(28
				(= seconds 2)
			)
			(29
				(curtis loop: 3 setCel: 0 setCycle: End self)
			)
			(30
				(tramLid init: ignoreActors: 1 setCel: 0)
				(curtis loop: 4 setCel: 0)
				(= ticks 180)
			)
			(31
				(curtis setCycle: CT 3 1 self)
				(tramLid setCycle: End)
			)
			(32
				(if (not local2)
					(gMessager say: 0 0 12 4 self) ; "Now, let me see... WHOOPS!"
				else
					(= local2 1)
					(self cue:)
				)
			)
			(33
				(= ticks 120)
			)
			(34
				(tramLid dispose:)
				(curtis setCycle: End self)
			)
			(35
				(= ticks 30)
			)
			(36
				(-= state 8)
				(self cue:)
			)
			(37
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tramFiddling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(curtis loop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(tramLid init: ignoreActors: 1 setCel: 0)
				(curtis loop: 4 setCel: 0)
				(= ticks 180)
			)
			(3
				(curtis setCycle: CT 3 1 self)
				(tramLid setCycle: End)
			)
			(4
				(= ticks 120)
			)
			(5
				(tramLid dispose:)
				(curtis setCycle: End self)
			)
			(6
				(sFx number: 345 loop: 1 play:)
				(= ticks 30)
			)
			(7
				(-= state 7)
				(self cue:)
			)
		)
	)
)

(instance rideTramOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 825 1) setMotion: MoveTo -25 85 self) ; tram
			)
			(1
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
				(if (not (IsFlag 36))
					(gCurRoom setScript: rideTramOut)
				else
					(gGame handsOn:)
					(Load rsSCRIPT 826)
					(LoadMany rsVIEW 88 82)
					(gTheIconBar
						disableIcon:
							(ScriptID 0 3) ; icon0
							(ScriptID 0 5) ; icon2
							(ScriptID 0 6) ; icon3
						show:
					)
					((ScriptID 825 1) ; tram
						setCycle: Walk
						setMotion: MoveTo 133 85 self
					)
				)
			)
			(1
				(SetFlag 70)
				(gGame handsOff:)
				(self setScript: (ScriptID 826 1) self) ; getOffTram
			)
			(2
				(if (and (not (IsFlag 160)) (IsFlag 205))
					(SetFlag 71)
				)
				(self setScript: (ScriptID 826 3) self) ; turnTramRight
			)
			(3
				(= cycles 2)
			)
			(4
				(if (and (not (IsFlag 160)) (IsFlag 205))
					(gTheIconBar
						enableIcon:
							(ScriptID 0 3) ; icon0
							(ScriptID 0 5) ; icon2
							(ScriptID 0 6) ; icon3
							(ScriptID 0 9) ; icon6
					)
					(ClearFlag 35)
					(ClearFlag 36)
					((ScriptID 825 0) ; theTramPath
						currentRoom: 820
						value: 58
						endType: -1
						next:
					)
					(gEgo setScript: takeABreak)
					(self dispose:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance takeABreak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 825 2) stop:) ; tramSoundFx
				(SetFlag 53)
				((ScriptID 825 1) dispose:) ; tram
				(thatOldTram view: 80 init:)
				(= ticks 210)
			)
			(1
				(gGame handsOn:)
				(curtis view: 91 setCycle: OccCyc self 1 30 90)
				(= seconds 16)
			)
			(2
				(= seconds 16)
			)
			(3
				(gGame handsOff:)
				(curtis
					view: 81
					setCycle: Walk
					cycleSpeed: 6
					ignoreActors: 1
					setStep: 4 2
					setMotion: MoveTo 75 84 self
				)
			)
			(4
				(curtis dispose:)
				(if (gCast contains: (ScriptID 825 1)) ; tram
					((ScriptID 825 1) dispose:) ; tram
				)
				(thatOldTram
					view: 83
					init:
					loop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(thatOldTram loop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 5 0 4 0 self) ; "The tram is just leaving for Kingman, Barstow, Cucamonga, and all points west."
			)
			(7
				(ClearFlag 71)
				(gEgo put: 14) ; flashlight
				(thatOldTram dispose:)
				(ClearFlag 23)
				((ScriptID 825 1) init: setMotion: (ScriptID 825 0)) ; tram, theTramPath
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goForSmoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 152 79 self)
			)
			(1
				(Face gEgo curtis self)
			)
			(2
				(gMessager say: 6 42 6 0 self) ; "Hey, Art! Ya wanna match?"
			)
			(3
				(gGame changeScore: 4 268)
				(gEgo put: 25) ; match
				(gGame handsOn:)
				(curtis
					view: 81
					ignoreActors: 1
					setCycle: Walk
					cycleSpeed: 9
					moveSpeed: 9
					xStep: 6
					setMotion: MoveTo 130 82 self
				)
				((ScriptID 825 2) stop:) ; tramSoundFx
				(thatOldTram view: 80 init: loop: 0 setCel: 0)
				(gCurRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 25 83 107 82 124 82 124 91 24 89
								yourself:
							)
						)
				)
			)
			(4
				(gGame handsOn:)
				(curtis ignoreActors: 0 setMotion: MoveTo 279 82 self)
			)
			(5
				(if (> (gEgo x:) 239)
					(gMessager say: 0 0 6 0 self) ; "Where do you think you're going?"
				else
					(self cue:)
				)
			)
			(6
				(curtis view: 92 setCel: 0 setCycle: End self)
			)
			(7
				(cardSlot setCycle: End self)
				(sFx number: 821 loop: 1 play: setVol: 127)
			)
			(8
				(curtis view: 81 setCycle: Walk setMotion: MoveTo 320 82 self)
			)
			(9
				(cardSlot setCycle: Beg self)
				(sFx number: 821 loop: 1 play:)
			)
			(10
				(if global205
					(proc79_7)
				)
				(curtis dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: -5 80
					init:
					normalize: 900
					setMotion: MoveTo 4 80 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromPool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					ignoreHorizon: 1
					posn: 61 33
					init:
					setMotion: DPath 91 51 101 66 self
				)
			)
			(1
				(gEgo ignoreHorizon: 0 normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromCamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 330 84
					init:
					normalize: 900 1
					setMotion: MoveTo 271 84 self
				)
				(cardSlot setCel: 6)
			)
			(1
				(cardSlot setCycle: Beg self)
				(sFx number: 821 loop: 1 play:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromExterior of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 219 186
					setScale: 0
					init:
					normalize: 900
					setMotion: DPath 213 139 206 121 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromEast of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 340 105
					init:
					normalize: 900
					setMotion: MoveTo 300 105 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance checkOutTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 136 91 self)
			)
			(1
				(if (not (IsFlag 265))
					(gMessager say: 5 4 0 0 self) ; "I wonder what this baby looks like under the hood..."
				else
					(self cue:)
				)
			)
			(2
				(gEgo
					view: 85
					setSpeed: 12
					loop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gGame changeScore: 6 265)
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: 830)
			)
		)
	)
)

(instance fromTramCU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gEgo setSpeed: 12 setCycle: Beg self)
			)
			(2
				(sFx number: 345 loop: 1 play:)
				(gEgo
					normalize: 900
					ignoreActors: 1
					setMotion: MoveTo 135 78 self
				)
			)
			(3
				(gEgo ignoreActors: 0 setHeading: 180 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(if (IsFlag 23)
					(gMessager say: 0 0 7 0 self) ; "That ought to cause this guy some trouble."
				else
					(gMessager say: 0 0 11 0 self) ; "All that electrical stuff under the hood confused you. Maybe you're a low-voltage kind of guy."
				)
			)
			(6
				(if (IsFlag 23)
					(thatOldTram setScript: curtisNTheTram)
				else
					(gCurRoom
						addObstacle:
							(= local0
								((Polygon new:)
									type: PBarredAccess
									init: 25 83 107 82 124 82 124 91 24 89
									yourself:
								)
							)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slideCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 821
					loop: 0
					setCel: 0
					setSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(sFx number: 823 loop: 1 play: setVol: 127)
			)
			(2
				(gMessager say: 2 10 0 0 self) ; "Breathlessly, you insert Cavarrichi Varnet's employee ID card into the slot on the electronic lock and hope there's no careful photo checking required."
			)
			(3
				(gEgo view: 900 setCycle: Walk)
				(cardSlot cycleSpeed: 12 setCycle: End self)
				(sFx number: 821 loop: 1 play: setVol: 127)
			)
			(4
				(gGame changeScore: 12 269)
				(gEgo normalize: 900 0 setMotion: MoveTo 330 82 self)
			)
			(5
				(= ticks 60)
			)
			(6
				(gCurRoom newRoom: 840)
			)
		)
	)
)

(instance grabFence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 294 82 self)
			)
			(1
				(gMessager say: 3 4 0 1 self) ; "Blatantly ignoring the "High Voltage" signs on the fence, you walk right up, grab the wires, and attempt to climb the fence."
			)
			(2
				(gEgo view: 822 loop: 0 setSpeed: 12 setCycle: CT 4 1 self)
			)
			(3
				(sFx number: 403 play: setLoop: -1 setVol: 127)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setCycle: CycleBet 7 8 3 self)
			)
			(5
				(sFx stop:)
				(gEgo loop: 1 cycleSpeed: 8 setCel: 0 setCycle: CT 6 1 self)
			)
			(6
				(sFx number: 520 loop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(7
				(= seconds 3)
			)
			(8
				(EgoDead 19 self)
			)
			(9
				(gEgo normalize: 900 0)
				(= ticks 75)
			)
			(10
				(gMessager say: 3 4 0 2 self) ; "That would have caused permanent brain damage in a better man!"
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance curtis of Actor
	(properties
		noun 6
		x 128
		y 84
		view 81
	)

	(method (cue)
		(gCurRoom setScript: gimmeMyLight)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					(local1
						(gCurRoom setScript: helpCurtis)
					)
					((== (gEgo script:) takeABreak)
						(gMessager say: 6 2 6) ; "Lose something?"
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(cond
					(local1
						(gMessager say: 6 1 7) ; "Art knows something is wrong under the hood, but he's unable to hold up the hood with one hand, aim the flashlight with his other hand, and then work on the motor with his other hand!"
						(return 1)
					)
					((== (thatOldTram script:) curtisNTheTram)
						(gMessager say: 6 1 3) ; "Art looks contented. At peace. One with the world."
						(return 1)
					)
					((== (gEgo script:) takeABreak)
						(gMessager say: 6 1 6) ; "Art seems to have lost something."
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((OneOf theVerb 42 43) ; match, match [ lit ]
				(if (== (gEgo script:) takeABreak)
					(gEgo setScript: 0)
					(gCurRoom setScript: goForSmoke)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thatOldTram of Prop
	(properties
		noun 5
		x 75
		y 85
		view 80
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 4 64) ; Do, wrench
				(cond
					((IsFlag 23)
						(gMessager say: 5 4 7) ; "There's nothing more you can do now, except stand and wait."
						(return 1)
					)
					((gCast contains: curtis)
						(gMessager say: 5 4 2) ; "If you're thinking of trying to do something to the tram, you'd better be more discrete! Art might see you."
						(return 1)
					)
					(else
						(gCurRoom setScript: checkOutTram)
					)
				)
			)
			(5 ; Take
				(if (gEgo has: 14) ; flashlight
					(gMessager say: 6 5 1) ; "The only thing Art had that you really wanted is in your hands right now. Make use of your time, Larry! DO something."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(24 ; flashlight
				(curtisTimer dispose:)
				(curtis cue:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cardSlot of Prop
	(properties
		noun 2
		approachX 276
		approachY 82
		x 311
		y 80
		view 820
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; badge
				(if
					(or
						(gCast contains: thatOldTram)
						(== ((ScriptID 825 0) currentRoom:) 820) ; theTramPath
					)
					(gMessager say: 2 10 2) ; "Hey! What do you think you're doing? You don't work here!"
					(return 1)
				else
					(gCurRoom setScript: slideCard)
				)
			)
			(1 ; Look
				(if
					(and
						(not (gCast contains: curtis))
						(gCast contains: thatOldTram)
					)
					(gMessager say: 2 1 9) ; "The tram driver used some sort of card on that electronic lock and the gate opened! There's obviously more hidden in that mature landscaping than just brambles!"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if
					(or
						(gCast contains: thatOldTram)
						(== ((ScriptID 825 0) currentRoom:) 820) ; theTramPath
					)
					(gMessager say: 2 10 2) ; "Hey! What do you think you're doing? You don't work here!"
					(return 1)
				else
					(gCurRoom setScript: grabFence)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tramLid of Prop
	(properties
		x 131
		y 91
		view 824
		loop 5
	)
)

(instance frontFlowers of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 107 37 116 96 91 144 94 157 103 191 102 204 138 0 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stairs of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 30 66 27 86 35 114 51 129 67 84 67 90 59 78 41 56 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance otherStairs of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 138 186 88 223 87 218 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftTree of Feature
	(properties
		noun 7
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 26 106 14 48 1 48 3 13 49 15 47 47 51 61 60 76 81 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightTree of Feature
	(properties
		noun 9
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 102 159 36 151 17 200 24 183 56 178 70 180 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance backFlowers of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 66 50 57 47 33 54 32 77 40 88 57 84 66 57 66
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties)
)

(instance curtisTimer of Timer
	(properties)
)

