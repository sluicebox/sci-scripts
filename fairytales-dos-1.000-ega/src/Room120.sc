;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use CDActor)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room120 0
)

(local
	local0
	local1
	local2
	[local3 200]
)

(procedure (localproc_0)
	(gate init:)
	(bench init:)
	(hedge init:)
	(window1 init:)
	(window2 init:)
	(house init:)
	(roof init:)
	(wall init:)
	(chimney init:)
	(road init:)
	(Cloud init:)
	(sky init:)
	(mountain init:)
)

(instance Room120 of FRoom
	(properties
		lookStr {Here is a house with a hedge around it.}
		picture 120
		style 0
		east 130
		south 170
		west 110
		southX 126
		southY 180
		eastX 320
		eastY 137
		westY 132
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(switch (gCindStory state:)
			(0
				(LoadMany rsSOUND 28 29 30 129 130)
			)
			(1
				(LoadMany rsSOUND 30 31 114 129 130 131 145 146 147)
			)
			(3
				(Load rsSOUND 30)
			)
			(4
				(Load rsSOUND 35)
				(self defeatEntrance: 1)
			)
		)
		(super init:)
		(proc10_29)
		(switch (gCindStory state:)
			(0
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 28 priority: 15 setLoop: -1 play:)
			)
			(1
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 30 priority: 15 setLoop: -1 play:)
			)
			(3
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 30 priority: 15 setLoop: -1 play:)
			)
			(4
				(gGlobalMusic number: 35 priority: 15 setLoop: -1 play:)
				(self defeatEntrance: 1)
			)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 209 164 225 148 319 140 319 173 199 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 149 85 150 73 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 127 0 0 319 0 319 126 225 126 223 134 178 134 176 127 32 127
					yourself:
				)
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(localproc_0)
		(if (OneOf (gCindStory state:) 0 1)
			(LoadMany rsVIEW 616 618 612 611)
			(cinderella
				selection: 0
				view: 610
				setLoop: 5
				cel: 2
				normal: 0
				ignoreActors: 1
				posn: 201 132 29
				init:
			)
			(headCin
				posn: (- (cinderella x:) 4) (cinderella y:) 29
				ignoreActors: 1
				init:
			)
			(arm
				posn: (- (cinderella x:) 4) (cinderella y:) 29
				cycleSpeed: 30
				ignoreActors: 1
				setCycle: End
				init:
			)
		)
		(switch (gCindStory state:)
			(0
				(gEgo doCode: egoDo120)
			)
			(1
				(gEgo doCode: egoDo120)
				(godmother
					view: 616
					cel: 0
					posn: 167 109
					setCycle: Fwd
					setLoop: 6
					init:
				)
			)
			(3
				(gEgo doCode: egoDo120)
				(Load rsVIEW 611)
				(cinderella
					selection: 0
					view: 613
					setLoop: 5
					cel: 2
					posn: 197 134
					setCycle: StopWalk
					init:
				)
			)
			(4
				(Load rsVIEW 611)
				(Load rsVIEW 602)
				(cinderella
					selection: 0
					view: 603
					normal: 0
					setLoop: 1
					cel: 0
					posn: 170 134
					init:
				)
			)
		)
	)

	(method (enterSpecial)
		(self cue:)
	)

	(method (cue)
		(super cue:)
		(gCindStory selectCode: cindSelect selection: 0)
		(switch (gCindStory state:)
			(0
				(cinderella lookStr: {A girl sits crying on the bench.})
				(cinderella setScript: enterBeforeStory)
			)
			(1
				(self setScript: enterAfterStory)
			)
			(3
				(cinderella lookStr: {Cinderella looks very happy.})
				(self setScript: beHappy)
			)
			(4
				(self setScript: enterWithPrince)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(not local1)
					(not (gCindStory selected:))
					(or
						(< (gEgo x:) 15)
						(> (gEgo y:) 160)
						(> (gEgo x:) 305)
					)
				)
				(gCurRoom setScript: encourage)
			)
		)
		(cond
			(script 0)
			((== (gCindStory state:) 1)
				(if
					(and
						(>= (gEgo x:) (godmother x:))
						(== (godmother loop:) 7)
					)
					(gCurRoom setScript: turnRight)
				)
				(if
					(and
						(< (gEgo x:) (godmother x:))
						(== (godmother loop:) 6)
					)
					(gCurRoom setScript: turnLeft)
				)
			)
		)
	)

	(method (dispose)
		(if defeatEntrance
			(self defeatEntrance: 0)
		)
		(gCindStory selectCode: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(gEgo doCode: 0)
		(super dispose: &rest)
	)
)

(instance turnLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(godmother setLoop: 8 setCycle: End self)
			)
			(1
				(godmother setLoop: 7 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance turnRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(godmother setLoop: 9 setCycle: End self)
			)
			(1
				(godmother setLoop: 6 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance beHappy of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc10_13
					2
					cinderella
					gEgo
					-1
					0
					(Format @local3 120 0 @global110) ; "Hi, %s, thanks for your help."
				)
				(proc10_13 2 cinderella gEgo self 1 120 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterBeforeStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo cinderella)
				(= seconds 3)
			)
			(1
				(self setScript: raiseToTalk self)
			)
			(2
				(proc10_13 3 cinderella gEgo self 1 120 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance enterWithPrince of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(prince
					view: 601
					posn: (gCurRoom westX:) (gCurRoom westY:)
					loop: 1
					cel: 0
					ignoreActors: 1
					setCycle: Walk
					init:
				)
				(= cycles 1)
			)
			(1
				(prince setMotion: PolyPath 40 134 self)
			)
			(2
				(NormalEgo 8 global139)
				(gEgo
					posn: (gCurRoom westX:) (gCurRoom westY:)
					init:
					setMotion: PolyPath (- (cinderella x:) 70) (cinderella y:)
				)
				(prince
					setMotion:
						PolyPath
						(- (cinderella x:) 26)
						(cinderella y:)
						self
				)
			)
			(3
				(prince cel: 0)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(4
				(proc10_13 0 prince cinderella self 1 120 3)
			)
			(5
				(cinderella setCycle: End self)
			)
			(6
				(proc10_13 0 cinderella prince self 1 120 4)
			)
			(7
				(proc10_13 0 prince cinderella self 1 120 5)
			)
			(8
				(proc10_13 2 cinderella prince self 1 120 6)
			)
			(9
				(prince hide:)
				(cinderella
					posn: (- (cinderella x:) 13) (cinderella y:)
					view: 603
					setLoop: 0
					cel: 0
				)
				(= cycles 1)
			)
			(10
				(cinderella cycleSpeed: 12 setCycle: End self)
			)
			(11
				(= ticks 60)
			)
			(12
				(proc10_13 0 prince cinderella self 1 120 7)
			)
			(13
				(proc10_13 0 prince cinderella self 1 120 8)
			)
			(14
				(proc10_13 0 cinderella prince self 1 120 9)
			)
			(15
				(cinderella setLoop: 2 cel: 0 setCycle: End self)
			)
			(16
				(= ticks 120)
			)
			(17
				(cinderella setLoop: 3 cel: 0 setCycle: End self)
			)
			(18
				(= ticks 120)
			)
			(19
				(proc10_13
					0
					prince
					gEgo
					self
					1
					(Format @local3 120 10 @global110) ; "Thank you, %s, for all your help."
				)
			)
			(20
				(proc10_13
					2
					cinderella
					gEgo
					self
					1
					(Format @local3 120 11 @global110) ; "I am so happy you came here, %s, so I could go to the ball."
				)
			)
			(21
				(proc10_13
					0
					prince
					gEgo
					self
					1
					(Format @local3 120 12 @global110) ; "I am so happy you came here, %s, so that I could meet Cinderella."
				)
			)
			(22
				(self setScript: (ScriptID 91 2) self) ; DisplayEnd
			)
			(23
				(gEgo setMotion: PolyPath 0 (gCurRoom westY:) self)
			)
			(24
				(gCindStory incState:)
				(gCindStory done: 1)
				(++ global145)
				(gCindStory done: 1)
				(= global144 gCindStory)
				(= global142 0)
				(if (== global143 global144)
					(= global143 0)
				)
				(= cycles 1)
			)
			(25
				(self dispose:)
			)
		)
	)
)

(instance enterAfterStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo cinderella)
				(if (< (gEgo x:) (godmother x:))
					(godmother setScript: turnLeft)
				)
				(= ticks 60)
			)
			(1
				(proc10_13
					0
					godmother
					gEgo
					self
					1
					(Format @local3 120 13 @global110) ; "Why hello, %s, are you having a nice time today?"
				)
			)
			(2
				(self setScript: raiseToTalk self)
			)
			(3
				(proc10_13 2 cinderella gEgo self 1 120 14)
			)
			(4
				(if (gEgo has: 0)
					(client setScript: returnPumpkin)
				else
					(proc10_13 3 gEgo cinderella self 1 120 15)
				)
			)
			(5
				(proc10_13 3 cinderella gEgo self 1 120 16)
			)
			(6
				(if (== (godmother loop:) 7)
					(godmother setScript: turnRight self)
				else
					(= cycles 1)
				)
			)
			(7
				(proc10_13
					0
					godmother
					cinderella
					self
					1
					(Format @local3 120 17 @global110) ; "Cinderella, dear, I am sure that %s can find the pumpkin for us."
				)
			)
			(8
				(proc10_13
					0
					godmother
					gEgo
					-1
					0
					(Format @local3 120 18 @global110) ; "%s, just keep looking."
				)
				(proc10_13 0 godmother gEgo self 1 120 19)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance returnPumpkin of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCindStory incState:)
				(= local0 ((gInventory at: 0) regView:))
				((local0 client:) owner: 0)
				(gGlobalMusic number: 31 priority: 15 setLoop: -1 play:)
				(= ticks 1)
			)
			(1
				(proc10_13 0 gEgo godmother self 1 120 20)
			)
			(2
				(proc10_13 2 cinderella gEgo self 1 120 21)
			)
			(3
				(proc10_13
					0
					godmother
					gEgo
					self
					1
					(Format @local3 120 22 @global110) ; "Thank you, %s. Please put the pumpkin over there."
				)
			)
			(4
				(gEgo setMotion: PolyPath 56 136 self)
			)
			(5
				(gEgo
					view: (+ 70 global139)
					loop: 0
					cel: 0
					normal: 0
					setCycle: CT 2 1 self
				)
			)
			(6
				(localSound number: 114 play:)
				(gTheIconBar curInvIcon: 0 show:)
				(local0 ignoreActors: 1 posn: 43 136 init:)
				(gEgo setCycle: End self)
			)
			(7
				(NormalEgo 8 global139)
				(gEgo normal: 1 setMotion: PolyPath 101 153 self)
			)
			(8
				(Face gEgo ((gInventory at: 0) regView:) self)
			)
			(9
				(if (== (godmother loop:) 2)
					(godmother setLoop: 8 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(10
				(localSound number: 131 play:)
				(coach loop: 0 cel: 0 setCycle: End self init:)
				(local0 dispose:)
				(godmother setLoop: 3 cel: 0 setCycle: Fwd)
			)
			(11
				(godmother setLoop: 9 setCycle: End self)
			)
			(12
				(godmother setLoop: 2 setCycle: Fwd)
				(arm dispose:)
				(headCin dispose:)
				(localSound number: 146 play:)
				(cinderella
					setLoop: 2
					normal: 0
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(13
				(godmother setLoop: 8 setCycle: End self)
			)
			(14
				(godmother setLoop: 3 setCycle: Fwd)
				((= temp0 (cinderella talkerObj:)) view: 612)
				((temp0 bust:) view: 612)
				((temp0 eyes:) view: 612)
				((temp0 mouth:) view: 612)
				(wheels
					setLoop: 2
					cel: 0
					ignoreActors: 1
					posn: (+ (coach x:) 3) (+ (coach y:) 47)
					init:
				)
				(wheels2
					setLoop: 2
					cel: 0
					ignoreActors: 1
					posn: (+ (coach x:) 62) (+ (coach y:) 47)
					init:
				)
				(coach setPri: 2 setLoop: 1 cel: 0 setCycle: End self)
			)
			(15
				(localSound number: 147 play:)
				(cinderella
					view: 120
					loop: 4
					cel: 0
					setPri: 15
					posn: 44 95 0
					setCycle: End self
				)
			)
			(16
				(proc10_13 0 godmother cinderella -1 0 120 23)
				(proc10_13 0 godmother cinderella self 1 120 24)
			)
			(17
				(proc10_13 2 cinderella godmother -1 0 120 25)
				(proc10_13
					2
					cinderella
					gEgo
					self
					1
					(Format @local3 120 26 @global110) ; "Thanks, %s. Bye-bye!"
				)
			)
			(18
				(godmother setLoop: 7 setCycle: Fwd)
				(wheels setCycle: Fwd setMotion: MoveTo -99 (+ (coach y:) 49))
				(wheels2 setCycle: Fwd setMotion: MoveTo -45 (+ (coach y:) 49))
				(cinderella
					setLoop: 3
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo -48 (cinderella y:)
				)
				(coach setMotion: MoveTo -100 (coach y:) self)
			)
			(19
				(coach dispose:)
				(wheels dispose:)
				(wheels2 dispose:)
				(cinderella dispose:)
				(= cycles 1)
			)
			(20
				(proc10_13
					0
					godmother
					gEgo
					self
					1
					(Format @local3 120 27 @global110) ; "Good-bye, %s, and thank you for your help."
				)
			)
			(21
				(localSound number: 145 play:)
				(godmother setLoop: 1 cel: 6 setCycle: Beg self)
			)
			(22
				(gGlobalMusic fade: 0 15 10 1)
				(= ticks 120)
			)
			(23
				(= global225 6)
				(proc10_29)
				(= cycles 1)
			)
			(24
				(gEgo doCode: 0)
				(godmother dispose:)
				(= cycles 1)
			)
			(25
				(self dispose:)
			)
		)
	)
)

(instance storySelect of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gCindStory selected: 1 incState:)
				(= global143 gCindStory)
				(cinderella
					lookStr: {Cinderella is very pretty when she smiles.}
				)
				(proc10_20 (gInventory at: 0))
				(gGlobalMusic number: 29 priority: 15 setLoop: -1 play:)
				(self setScript: (ScriptID 91 1) self) ; DisplayStart
			)
			(1
				(localSound number: 129 play:)
				(godmother view: 616 cel: 0 posn: 167 109 loop: 0 init:)
				(gEgo selection: 0)
				(cinderella selection: 0)
				(= cycles 1)
			)
			(2
				(godmother setCycle: End self)
			)
			(3
				(godmother setLoop: 6 cel: 0)
				(proc10_13 0 godmother cinderella self 1 120 28)
			)
			(4
				(proc10_13 2 cinderella godmother self 1 120 29)
			)
			(5
				(proc10_13 0 godmother cinderella self 1 120 30)
			)
			(6
				(proc10_13 2 cinderella godmother self 1 120 31)
			)
			(7
				(proc10_13 0 godmother cinderella self 1 120 32)
			)
			(8
				(proc10_13 0 godmother cinderella self 1 120 33)
			)
			(9
				(godmother setLoop: 2 setCycle: End self)
			)
			(10
				(godmother cel: 7 setCycle: Beg self)
			)
			(11
				(godmother setLoop: 4 cel: 0 setCycle: End)
				(= ticks 120)
			)
			(12
				(gGlobalMusic number: 30 priority: 15 setLoop: -1 play:)
				(godmother setLoop: 6 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(13
				(proc10_13 3 cinderella godmother self 1 120 34)
			)
			(14
				(proc10_13 3 godmother cinderella self 0 120 35)
			)
			(15
				(proc10_13 3 godmother cinderella self 1 120 36)
			)
			(16
				(proc10_13 3 cinderella godmother self 1 120 37)
			)
			(17
				(if (< (gEgo x:) (godmother x:))
					(godmother setScript: turnLeft self)
				else
					(= cycles 1)
				)
			)
			(18
				(= cycles 5)
			)
			(19
				(proc10_13
					2
					godmother
					gEgo
					self
					1
					(Format @local3 120 38 @global110) ; "%s, will you help us, please?"
				)
			)
			(20
				(proc10_13 0 godmother gEgo self 1 120 39)
			)
			(21
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance encourage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(= local1 1)
				(Face gEgo cinderella)
				(= cycles 1)
			)
			(2
				(proc10_13 3 cinderella gEgo self 1 120 40)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance raiseToTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(headCin setCycle: CT 1 1 self)
			)
			(1
				(headCin cel: 2)
				(cinderella normal: 1)
				(Animate (gCast elements:) 1)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance cindSelect of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: storySelect)
	)
)

(instance egoDo120 of Code
	(properties)

	(method (doit param1)
		(if (== param1 5)
			(gEgo setScript: do120Script)
		)
	)
)

(instance do120Script of HandsOffScript
	(properties)

	(method (dispose)
		(gEgo incSel:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gCindStory state:)
					(0
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo cinderella self 1 120 41)
							)
							(1
								(proc10_13 2 gEgo cinderella self 1 120 42)
							)
							(2
								(proc10_13 2 gEgo cinderella self 1 120 43)
							)
							(else
								(proc10_13 2 gEgo cinderella self 1 120 44)
							)
						)
					)
					(1
						(cond
							(local2
								(switch (gEgo selection:)
									(0
										(proc10_13
											0
											gEgo
											cinderella
											self
											1
											120
											45
										)
									)
									(1
										(proc10_13
											2
											gEgo
											cinderella
											self
											1
											120
											46
										)
									)
									(2
										(proc10_13
											2
											gEgo
											cinderella
											self
											1
											120
											47
										)
									)
									(else
										(proc10_13
											2
											gEgo
											cinderella
											self
											1
											120
											48
										)
									)
								)
							)
							((not (gEgo has: 0))
								(proc10_13 0 gEgo cinderella self 1 120 49)
							)
							(else
								(= cycles 1)
							)
						)
					)
					(3
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo cinderella self 1 120 50)
							)
							(1
								(proc10_13 0 gEgo cinderella self 1 120 51)
							)
							(2
								(proc10_13 0 gEgo cinderella self 1 120 52)
							)
							(else
								(proc10_13 0 gEgo cinderella self 1 120 53)
							)
						)
					)
				)
			)
			(1
				(switch (gCindStory state:)
					(0
						(switch (gEgo selection:)
							(0
								(proc10_13 3 cinderella gEgo self 0 120 54)
							)
							(1
								(proc10_13 3 cinderella gEgo -1 0 120 55)
								(proc10_13 3 cinderella gEgo self 1 120 56)
							)
							(2
								(proc10_13 0 cinderella gEgo -1 0 120 57)
								(proc10_13 0 cinderella gEgo -1 0 120 58)
								(proc10_13 0 cinderella gEgo self 1 120 59)
							)
							(else
								(proc10_13 0 cinderella gEgo -1 0 120 60)
								(proc10_13 0 cinderella gEgo self 1 120 61)
							)
						)
					)
					(1
						(if local2
							(switch (gEgo selection:)
								(0
									(self dispose:)
								)
								(1
									(proc10_13 2 cinderella gEgo -1 0 120 62)
									(proc10_13 2 cinderella gEgo -1 0 120 63)
									(proc10_13
										2
										cinderella
										gEgo
										self
										1
										120
										64
									)
								)
								(2
									(proc10_13 0 godmother gEgo -1 0 120 65)
									(proc10_13 0 godmother gEgo -1 0 120 66)
									(proc10_13 3 godmother gEgo -1 0 120 67)
									(proc10_13
										0
										godmother
										gEgo
										self
										1
										120
										68
									)
								)
								(else
									(proc10_13 0 godmother gEgo -1 0 120 69)
									(proc10_13
										0
										godmother
										gEgo
										self
										1
										120
										70
									)
								)
							)
						else
							(self dispose:)
						)
					)
					(3
						(if (== (gEgo selection:) 0)
							(proc10_13 2 cinderella gEgo -1 0 120 71)
							(proc10_13 2 cinderella gEgo self 1 120 72)
						else
							(self dispose:)
						)
					)
				)
			)
			(2
				(switch (gCindStory state:)
					(0
						(if (== (gEgo selection:) 0)
							(proc10_13 2 cinderella gEgo -1 0 120 73)
							(proc10_13 2 cinderella gEgo self 1 120 74)
						else
							(self dispose:)
						)
					)
					(1
						(if (== (gEgo selection:) 1)
							(proc10_13 0 godmother gEgo self 1 120 75)
						else
							(self dispose:)
						)
					)
					(3
						(self dispose:)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance gate of Feature
	(properties
		x 151
		y 112
		nsTop 101
		nsLeft 135
		nsBottom 124
		nsRight 168
		description {Gate}
		sightAngle 90
		lookStr {The gate is locked.}
	)
)

(instance hedge of Feature
	(properties
		x 165
		y 112
		nsTop 102
		nsLeft 56
		nsBottom 123
		nsRight 274
		description {Hedge}
		sightAngle 90
		lookStr {The hedge makes a wall around the house.}
	)
)

(instance window1 of Feature
	(properties
		x 157
		y 82
		nsTop 55
		nsLeft 133
		nsBottom 72
		nsRight 182
		description {Window}
		sightAngle 90
		lookStr {The windows are very clean.}
	)
)

(instance window2 of Feature
	(properties
		x 200
		y 95
		nsTop 87
		nsLeft 180
		nsBottom 103
		nsRight 221
		sightAngle 90
	)

	(method (doVerb theVerb)
		(window1 doVerb: theVerb)
	)
)

(instance house of Feature
	(properties
		x 176
		y 81
		description {House}
		sightAngle 90
		onMeCheck 2
		lookStr {This house is neat and clean.}
	)
)

(instance chimney of Feature
	(properties
		x 195
		y 53
		description {Chimney}
		onMeCheck 2048
		lookStr {The chimney lets out the smoke from the fireplace.}
	)
)

(instance road of Feature
	(properties
		x 100
		y 160
		description {Road}
		sightAngle 90
		onMeCheck 32
		lookStr {The road heads east, south, and west from here.}
	)
)

(instance Cloud of Feature
	(properties
		x 84
		y 45
		description {Clouds}
		sightAngle 90
		onMeCheck 128
		lookStr {Clouds are just water in the sky.}
	)
)

(instance sky of Feature
	(properties
		x 132
		y 33
		description {Sky}
		sightAngle 90
		onMeCheck 512
		lookStr {The sky here is very pretty.}
	)
)

(instance mountain of Feature
	(properties
		x 47
		y 48
		description {Mountains}
		sightAngle 90
		onMeCheck 8192
		lookStr {The mountains are far from the town.}
	)
)

(instance roof of Feature
	(properties
		x 176
		y 60
		description {Roof}
		sightAngle 90
		onMeCheck 1024
		lookStr {The roof of the house is made of wood.}
	)
)

(instance wall of Feature
	(properties
		x 57
		y 74
		description {Wall}
		sightAngle 90
		onMeCheck 64
		lookStr {The wall goes around the house.}
	)
)

(instance bench of Feature
	(properties
		x 200
		y 118
		nsTop 106
		nsLeft 181
		nsBottom 131
		nsRight 218
		description {Bench}
		lookStr {The bench is a good place to sit.}
	)
)

(instance arm of Prop
	(properties
		view 610
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(cinderella doVerb: theVerb)
	)
)

(instance headCin of Prop
	(properties
		view 610
		signal 16384
	)

	(method (doVerb theVerb)
		(cinderella doVerb: theVerb)
	)
)

(instance wheels of Actor
	(properties
		view 120
		loop 2
	)
)

(instance wheels2 of Actor
	(properties
		view 120
		loop 2
	)
)

(instance coach of Actor
	(properties
		x -10
		y 60
		view 120
	)
)

(instance cinderella of CDActor
	(properties
		description {Girl}
		lookStr {A pretty girl sits on the bench.}
		talkerID 2
	)

	(method (setUp)
		((= talkerObj cinTalkObj) setUp: cinBust cinEyes cinMouth)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(switch (gCindStory state:)
					(0
						(switch (self selection:)
							(0
								(proc10_13 3 cinderella gEgo -1 1 120 76)
							)
							(1
								(proc10_13 3 self gEgo -1 1 120 77)
							)
							(2
								(proc10_13 2 cinderella gEgo -1 1 120 78)
							)
							(2
								(proc10_13 0 cinderella gEgo -1 0 120 79)
								(proc10_13 0 cinderella gEgo -1 1 120 80)
							)
							(else
								(proc10_13 0 self gEgo -1 1 120 81)
							)
						)
					)
					(1
						(cond
							(local2
								(switch (self selection:)
									(0
										(proc10_13 0 self gEgo -1 0 120 82)
										(proc10_13 0 self gEgo -1 1 120 83)
									)
									(1
										(proc10_13 0 self gEgo -1 0 120 84)
										(proc10_13 0 self gEgo -1 1 120 85)
									)
									(2
										(proc10_13
											3
											cinderella
											gEgo
											-1
											1
											120
											86
										)
									)
									(else
										(proc10_13 3 self gEgo -1 1 120 87)
									)
								)
							)
							((not (gEgo has: 0))
								(proc10_13 3 cinderella gEgo -1 1 120 88)
							)
						)
					)
					(3
						(switch (self selection:)
							(0
								(proc10_13 2 self gEgo -1 1 120 89)
							)
							(1
								(proc10_13 0 self gEgo -1 0 120 90)
								(proc10_13 0 self gEgo -1 1 120 91)
							)
							(2
								(proc10_13 2 self gEgo -1 0 120 92)
								(proc10_13 2 self gEgo -1 1 120 93)
							)
							(else
								(proc10_13 2 self gEgo -1 0 120 94)
								(proc10_13 0 self gEgo -1 1 120 95)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cinTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 611
	)
)

(instance cinBust of View
	(properties
		nsTop 21
		nsLeft 47
		view 611
		loop 6
	)
)

(instance cinEyes of Prop
	(properties
		nsTop 28
		nsLeft 50
		view 611
		loop 4
		cycleSpeed 36
	)
)

(instance cinMouth of Prop
	(properties
		nsTop 36
		nsLeft 41
		view 611
		loop 2
		cycleSpeed 12
	)
)

(instance godmother of Tactor
	(properties
		description {Fairy Godmother}
		lookStr {This is Cinderella's Fairy Godmother. She can do magic.}
		talkerID 3
	)

	(method (init)
		((= talkerObj godMomTalkObj) setUp: godMomBust godMomEyes godMomMouth)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(switch (gCindStory state:)
					(1
						(cond
							(local2
								(switch (self selection:)
									(0
										(proc10_13 0 self gEgo -1 1 120 96)
									)
									(1
										(proc10_13 0 self gEgo -1 0 120 97)
										(proc10_13 0 self gEgo -1 0 120 98)
										(proc10_13 0 self gEgo -1 1 120 99)
										(proc10_13
											3
											cinderella
											gEgo
											-1
											1
											120
											100
										)
									)
									(2
										(proc10_13
											0
											godmother
											godmother
											-1
											1
											(Format @local3 120 101 @global110) ; "%s, please find the pumpkin."
										)
									)
									(else
										(proc10_13 0 self gEgo -1 1 120 102)
									)
								)
							)
							((not (gEgo has: 0))
								(proc10_13 0 godmother gEgo -1 0 120 103)
								(proc10_13 0 godmother gEgo -1 1 120 104)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance godMomTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 618
	)
)

(instance godMomBust of View
	(properties
		nsTop 28
		nsLeft 43
		view 618
		loop 6
	)
)

(instance godMomEyes of Prop
	(properties
		nsTop 33
		nsLeft 46
		view 618
		loop 4
		cycleSpeed 36
	)
)

(instance godMomMouth of Prop
	(properties
		nsTop 41
		nsLeft 41
		view 618
		loop 2
		cycleSpeed 12
	)
)

(instance prince of Tactor
	(properties
		talkerID 4
	)

	(method (init)
		((= talkerObj princeTalkObj) setUp: princeBust princeEyes princeMouth)
		(super init: &rest)
	)
)

(instance princeTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 602
	)
)

(instance princeBust of View
	(properties
		nsTop 24
		nsLeft 42
		view 602
		loop 6
	)
)

(instance princeEyes of Prop
	(properties
		nsTop 31
		nsLeft 44
		view 602
		loop 4
		cycleSpeed 36
	)
)

(instance princeMouth of Prop
	(properties
		nsTop 41
		nsLeft 41
		view 602
		loop 2
		cycleSpeed 12
	)
)

(instance localSound of Sound
	(properties
		flags 1
		number 129
	)
)

