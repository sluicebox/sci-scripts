;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	HedgeRow 0
	itsToLate 1
	runFerDoor 2
)

(local
	local0
	[local1 4] = [1490 7 1 0]
	[local5 4] = [1490 8 1 0]
	[local9 4] = [1490 14 1 0]
	[local13 9] = [431 0 2 4 23 34 24 25 1]
)

(class HedgeRow of Rm
	(properties
		picture 490
		vanishingX -4000
		vanishingY -6000
		teleX 0
		teleY 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(if (== gDay 10)
					(Say 1490 1 1) ; "True, I could fire an arrow into the air and over the hedge maze, but I might strike an innocent person outside, since I cannot see beyond the maze."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Inventory
				(if
					(or
						(== invItem 0) ; bucks
						(== invItem 2) ; halfHeart
						(== invItem 11) ; cask
						(== invItem 14) ; amethyst
						(== invItem 12) ; puzzleBox
						(== invItem 10) ; fireRing
						(== invItem 18) ; waterRing
						(== invItem 13) ; robes
					)
					(Say 1490 2 1) ; "I can think of no reason to leave it here."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(HandsOn)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (> gPrevRoomNum 85) ; hedge12
			(LoadMany rsSCRIPT 30 35 40 45 50 55 60 65 70 75 80 85)
			(LoadMany rsVIEW 500 12 13)
		)
		(gTheIconBar disable: 5)
		(AddToFeatures DMZ)
		(++ global158)
		(cond
			((or (== gDay 5) (== gDay 6))
				(gEgo actions: egoMonkActions)
			)
			((== gDay 10)
				(gEgo actions: egoOutlawActions)
			)
			(else
				(gEgo actions: egoHornActions)
			)
		)
		(if (== gDisguiseNum 0) ; outlaw
			(NormalEgo global111 12 13)
		else
			(NormalEgo global111 25 26)
		)
		(if (== gDisguiseNum 0) ; outlaw
			(gEgoHead z: 22)
		else
			(gEgoHead z: 20)
		)
		(switch ((User alterEgo:) edgeHit:)
			(EDGE_TOP
				(self style: 14)
			)
			(EDGE_BOTTOM
				(self style: 13)
			)
			(EDGE_RIGHT
				(self style: 12)
			)
			(EDGE_LEFT
				(self style: 11)
			)
			(else
				(self style: 100)
			)
		)
		(gEgo setScript: egoEnters)
		(super init:)
		(self overlay: gCurRoomNum)
	)

	(method (doit &tmp temp0)
		(gEgo
			priority:
				(= temp0
					(switch (gEgo onControl: 1)
						(1 0)
						(2 1)
						(4 2)
						(8 3)
						(16 4)
						(32 5)
						(64 6)
						(128 7)
						(256 8)
						(512 9)
						(1024 10)
						(2048 11)
						(4096 12)
						(8192 13)
						(16384 14)
					)
				)
			signal: (| (gEgo signal:) $0010)
		)
		(gEgoHead priority: temp0 signal: (| (gEgoHead signal:) $0010))
		(if
			(and
				(or
					(<= (gEgo x:) 2)
					(>= (gEgo x:) 317)
					(<= (gEgo y:) 2)
					(>= (gEgo y:) 187)
				)
				(> temp0 0)
			)
			(= global131 temp0)
			(= global111 (gEgo loop:))
			(= gForestSweepRoomCount (gEgo cel:))
		)
		(if (and ((User alterEgo:) edgeHit:) (not (gEgo script:)))
			(HandsOff)
			(switch ((User alterEgo:) edgeHit:)
				(EDGE_TOP
					(gCurRoom newRoom: (+ gCurRoomNum 5))
				)
				(EDGE_BOTTOM
					(if (== gCurRoomNum 45) ; hedge4
						(if (== gDay 10)
							(gEgo setScript: itsToLate)
						else
							(= global158 0)
							(gCurRoom newRoom: 480)
						)
					else
						(gCurRoom newRoom: (- gCurRoomNum 5))
					)
				)
				(EDGE_RIGHT
					(gCurRoom newRoom: (- gCurRoomNum 15))
				)
				(EDGE_LEFT
					(gCurRoom newRoom: (+ gCurRoomNum 15))
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		((gCurRoom obstacles:) eachElementDo: #dispose)
		(gRgnMusic fade: 0 30 8 1)
		(gTheIconBar enable: 5)
		(if (> gNewRoomNum 85) ; hedge12
			(DisposeScript 490 30 35 40 45 50 55 60 65 70 75 80 85)
		)
		(super dispose:)
	)
)

(class Hedge of PicView
	(properties
		view 500
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== loop 1)
					(Say 1490 10 1) ; "I can barely make out stone walls lining the outside of the hedge maze."
				else
					(Say 1490 0 1) ; "'Tis the hedge."
				)
			)
			(3 ; Do
				(if (== loop 1)
					(Say 1490 11 1) ; "I cannot touch the stone wall through the thick hedge."
				else
					(Say 1490 12 1) ; "The hedges are far too thick to part by hand."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hornSound of Sound
	(properties
		flags 1
		number 904
	)
)

(instance DMZ of Feature
	(properties
		y 6
		nsBottom 12
		nsRight 319
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(and
				(== gTheCursor 0)
				(> gMouseX 0)
				(< gMouseX 319)
				(self onMe: event)
			)
			(event claimed: 1)
			(gEgo setScript: northToAlaska)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global143)
					(HandsOff)
				)
				(cond
					((== gPrevRoomNum 500)
						(gEgo posn: 108 50 loop: 2 init:)
						(if (== gDisguiseNum 0) ; outlaw
							(gEgoHead z: 22)
						else
							(gEgoHead z: 20)
						)
						(= ticks 18)
					)
					((== gPrevRoomNum 480)
						(if (< global104 160)
							(gEgo
								posn: 204 188
								normal: 1
								moveHead: 1
								init:
								setMotion: PolyPath 191 171 self
							)
						else
							(gEgo
								posn: 264 188
								normal: 1
								moveHead: 1
								init:
								setMotion: PolyPath 267 154 self
							)
						)
						(if (== gDisguiseNum 0) ; outlaw
							(gEgoHead z: 22)
						else
							(gEgoHead z: 20)
						)
					)
					(else
						(gEgo
							x:
								(switch ((User alterEgo:) edgeHit:)
									(EDGE_TOP global104)
									(EDGE_BOTTOM global104)
									(EDGE_RIGHT 0)
									(EDGE_LEFT 319)
									(else
										(gCurRoom teleX:)
									)
								)
							y:
								(switch ((User alterEgo:) edgeHit:)
									(EDGE_RIGHT global105)
									(EDGE_LEFT global105)
									(EDGE_TOP 189)
									(EDGE_BOTTOM 0)
									(else
										(gCurRoom teleY:)
									)
								)
							xStep: 3
							yStep: 2
							setPri: global131
							setCel: gForestSweepRoomCount
							normal: 1
							moveHead: 1
							init:
						)
						(if (== gDisguiseNum 0) ; outlaw
							(gEgoHead z: 22)
						else
							(gEgoHead z: 20)
						)
						(cond
							((== ((User alterEgo:) edgeHit:) EDGE_BOTTOM)
								(cond
									((and (> (gEgo x:) 290) (== gPrevRoomNum 50)) ; hedge5
										(gEgo
											setMotion: PolyPath 317 24 self
										)
									)
									((and (== gPrevRoomNum 50) (> (gEgo x:) 290)) ; hedge5
										(gEgo
											setMotion: PolyPath 314 27 self
										)
									)
									(else
										(gEgo
											setMotion:
												PolyPath
												(+ (gEgo x:) 21)
												(+ (gEgo y:) 33)
												self
										)
									)
								)
							)
							((== ((User alterEgo:) edgeHit:) EDGE_TOP)
								(gEgo
									setMotion:
										PolyPath
										(- (gEgo x:) 7)
										(- (gEgo y:) 11)
										self
								)
							)
							((== ((User alterEgo:) edgeHit:) EDGE_RIGHT)
								(cond
									((and (== gPrevRoomNum 75) (< (gEgo y:) 78)) ; hedge10
										(gEgo setMotion: PolyPath 13 32 self)
									)
									(
										(or
											(and
												(== gPrevRoomNum 50) ; hedge5
												(< (gEgo y:) 150)
												(> (gEgo y:) 95)
											)
											(== gPrevRoomNum 75) ; hedge10
											(and
												(== gPrevRoomNum 55) ; hedge6
												(< (gEgo y:) 118)
												(> (gEgo y:) 88)
											)
											(and
												(== gPrevRoomNum 65) ; hedge8
												(>= (gEgo y:) 60)
											)
										)
										(= ticks 12)
									)
									(else
										(gEgo
											setMotion:
												PolyPath
												(+ (gEgo x:) 20)
												(gEgo y:)
												self
										)
									)
								)
							)
							((== ((User alterEgo:) edgeHit:) EDGE_LEFT)
								(cond
									((and (== gPrevRoomNum 60) (< (gEgo y:) 70)) ; hedge7
										(gEgo
											setMotion: PolyPath 317 24 self
										)
									)
									(
										(or
											(and
												(== gPrevRoomNum 35) ; hedge2
												(< (gEgo y:) 150)
												(> (gEgo y:) 95)
											)
											(and
												(== gPrevRoomNum 65) ; hedge8
												(> (gEgo y:) 120)
											)
											(== gPrevRoomNum 40) ; hedge3
											(== gPrevRoomNum 60) ; hedge7
										)
										(= ticks 12)
									)
									((and (== gPrevRoomNum 65) (< (gEgo y:) 78)) ; hedge8
										(gEgo
											setMotion: PolyPath 317 24 self
										)
									)
									((and (== gPrevRoomNum 30) (< (gEgo y:) 22)) ; hedge1
										(gEgo
											setMotion: PolyPath 314 27 self
										)
									)
									(else
										(gEgo
											setMotion:
												PolyPath
												(- (gEgo x:) 20)
												(gEgo y:)
												self
										)
									)
								)
							)
							(else
								(= ticks 12)
							)
						)
					)
				)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5)
				(SetIcon 0)
				(cond
					((and (== gDay 10) (>= global158 11))
						(gEgo setScript: itsToLate)
					)
					(
						(and
							(== gDay 10)
							(== gCurRoomNum 70) ; hedge9
							(< (gEgo y:) 75)
						)
						(gEgo setScript: thisIsIt)
					)
					((== gPrevRoomNum 480)
						(gCurRoom style: 100)
						(if (== gDay 10)
							(gEgo setScript: hurryDay10)
						else
							(self dispose:)
						)
						(if (== gDisguiseNum 0) ; outlaw
							(gEgoHead z: 22)
						else
							(gEgoHead z: 20)
						)
					)
					(else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance thisIsIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 116 52 self)
			)
			(1
				(Say 1490 13 self) ; "I can hear the angry muttering of the crowd outside."
			)
			(2
				(Converse 1 @local9 @local13 0 self) ; "Burn the witch!"
			)
			(3
				(Say 1490 15 self) ; "I'm barely in time!"
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0 5)
				(= seconds 5)
			)
			(5
				(if (gGame script:)
					(-- state)
					(= cycles 1)
				else
					(gEgo setScript: runFerDoor)
				)
			)
		)
	)
)

(instance runFerDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 116 52 self)
			)
			(1
				(if (or (== global146 30) (== global146 40))
					(= local0 1)
					(Say 1490 16 self) ; "Where is Little John?! If he doesn't come--"
				else
					(self cue:)
				)
			)
			(2
				(if local0
					(hornSound init: play: self)
				else
					(self cue:)
				)
			)
			(3
				(if local0
					(Say 1490 17 self) ; "I hear Will's horn. I must act NOW!"
					(hornSound dispose:)
				else
					(self cue:)
				)
			)
			(4
				(gEgo setMotion: PolyPath 106 52 self)
			)
			(5
				(gEgo setMotion: PolyPath 106 49 self)
			)
			(6
				(= global158 0)
				(gCurRoom newRoom: 501) ; jwitchct
				(HandsOn)
			)
		)
	)
)

(instance hurryDay10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 16)
			)
			(1
				(Say 1490 3 self) ; "Even from this distance, I can hear the angry muttering of the crowd outside the witch's court."
			)
			(2
				(Say 1490 4 self) ; "And there...faintly...I hear the Abbot's voice calling out above the crowd."
			)
			(3
				(Converse 1 @local1 @local13 0 self) ; "Bring in the Witch!"
			)
			(4
				(Say 1490 6 self) ; "I have little time! They will light the fire at any moment!"
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance itsToLate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Converse 1 @local5 @local13 0 self) ; "Light the pyre! Let the witch burn!"
			)
			(1
				(Say 1490 9 self) ; "I am too late! Marian! MARIAAAAAAAN!"
			)
			(2
				(SetScore -500 5)
				(= gDeathNum 40)
				(gCurRoom newRoom: 170) ; robinDeath
				(HandsOn)
			)
		)
	)
)

(instance northToAlaska of Script
	(properties)

	(method (doit)
		(if (gEgo edgeHit:)
			(HandsOn)
			(gEgo setMotion: 0 setScript: 0)
			(if (< (gEgo y:) 12)
				(gEgo posn: (gEgo x:) 0)
			)
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					signal: (| (gEgo signal:) $2000)
					setMotion: PolyPath gMouseX -2 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoMonkActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 12)) ; Inventory, puzzleBox
				(Say 1490 18 1) ; "I'll wait for a safer place to work on the puzzle box."
				1
			)
		)
	)
)

(instance egoOutlawActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(switch invItem
					(12 ; puzzleBox
						(Say 1490 19 1) ; "I've no time for the puzzle box now!"
						1
					)
					(1 ; horn
						(Say 1490 20 1) ; "That would be extemely stupid here in the middle of town."
						1
					)
				)
			)
		)
	)
)

(instance egoHornActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
				(Say 1490 20 1) ; "That would be extemely stupid here in the middle of town."
				1
			)
		)
	)
)

