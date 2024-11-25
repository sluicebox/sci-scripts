;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room16 0
)

(synonyms
	(kiss kiss embrace)
	(ghoul ghoul ghoul ghoul man ghoul ghoul)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance zTheme of Sound
	(properties)
)

(instance Room16 of Rm
	(properties
		picture 16
	)

	(method (init)
		(= north 10)
		(= south 22)
		(= east 17)
		(= west 15)
		(= horizon 80)
		(= gIndoors 0)
		(= global186 0)
		(if gNight
			(= picture 116)
		)
		(Load rsVIEW 47)
		(Load rsVIEW 21)
		(if (<= (gEgo y:) (+ horizon 1))
			(gEgo y: (+ horizon 1))
		)
		(if (== gPrevRoomNum 22)
			(gEgo x: 158)
		)
		(super init:)
		(self setRegions: 510) ; cemReg
		(if gNight
			(Load rsVIEW 261)
			(Load rsVIEW 263)
			(Load rsVIEW 265)
			(Load rsVIEW 36)
			(Load rsVIEW 46)
			(Load rsVIEW 45)
			(= local0 (Act new:))
			(= local1 (Act new:))
			(= local2 (Act new:))
			(local0
				view: 260
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 250 117
				setScript: z1Actions
				init:
				hide:
			)
			(local1
				view: 262
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 70 124
				setScript: z2Actions
				init:
				hide:
			)
			(local2
				view: 264
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 103 173
				setScript: z3Actions
				init:
				hide:
			)
		)
		(gEgo view: 2 observeControl: 16384 init:)
		(= global105 0)
		(gCurRoom setScript: holeActions)
		(for ((= local6 1)) (<= local6 gShovelCount) ((++ local6))
			(if (== [global138 (= local5 (* (- local6 1) 3))] gCurRoomNum)
				((View new:)
					view: 528
					loop: 0
					cel: 6
					posn: [global138 (+ local5 1)] [global138 (+ local5 2)]
					setPri: 0
					addToPic:
					ignoreActors:
				)
			)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(zTheme dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gEgo illegalBits: $8000)
		(= global189 0)
		(if (== (gEgo view:) 2)
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/gravestone')
					(Print 16 0) ; "Each tombstone has an epitaph written on it."
				)
				((Said 'read,look/epitaph,gravestone,boulder')
					(cond
						((& (gEgo onControl: 0) $0008)
							(Print 16 1 #mode 1 #at -1 15 #width 290) ; "1643 Here lies Newberry Will, His life was finished 'cause he took ill, But none'll miss him, he should've been wiser, 'Tis his own fault, for bein' such a miser."
						)
						((& (gEgo onControl: 0) $0020)
							(Print 16 2 #mode 1 #at -1 15 #width 290) ; "Here lies the body of Mary Ann Lowder, She burst while drinking a seidlitz powder, Called from this world to her heavenly rest, She should have waited till it effervesced."
						)
						((& (gEgo onControl: 0) $0100)
							(Print 16 3 #mode 1 #at -1 15 #width 290) ; "To the ever living memory of Hiram Bennet, baby son of Edward and Sarah Bennet, who by a sudden-surprize fell asleep, the 11th day of November, 1553 Aged 6 months."
						)
						((& (gEgo onControl: 0) $0200)
							(Print 16 4 #mode 1 #at -1 15 #width 290) ; "Six feet beneath This funeral wreath Is laid upon the shelf One Jerry Jones, Who dealt in bones, And now he's bones himself."
						)
						((& (gEgo onControl: 0) $0004)
							(Print 16 5 #mode 1 #at -1 15 #width 290) ; "Lord Coningsby 1559 to 1626 Sleepeth here in peace: an honorable man, a valiant soldier. He served his country well."
						)
						((& (gEgo onControl: 0) $0002)
							(Print 16 6 #mode 1 #at -1 15 #width 290) ; "I plant these shrubs upon your grave, dear wife, That something on this spot may boast of life. Shrubs must whither and all earth must rot; Shrubs may revive: but you, thank heaven, will not."
						)
						((& (gEgo onControl: 0) $0080)
							(Print 16 7 #mode 1 #at -1 15 #width 290) ; "Beneath this stone, a lump of clay, Lies Uncle Peter Dan'els, Who, early in the month of May, Took off his winter flannels."
						)
						((& (gEgo onControl: 0) $0040)
							(Print 16 8 #mode 1 #at -1 15 #width 290) ; "Dr. I Letsome When people's ill they come to I, I physics, bleeds, and sweats 'em; Sometimes they live, Sometimes they die; What's that to I? I Letsome."
						)
						((& (gEgo onControl: 0) $0010)
							(Print 16 9 #mode 1 #at -1 15 #width 290) ; "Here I lie with my three daughters, Who died drinking Chelt'nam waters. If we had stuck to Epsom Salt, We should not sleep in this cold vault."
						)
						((& (gEgo onControl: 0) $0400)
							(Print 16 10 #mode 1 #at -1 15 #width 290) ; "Strong and athletic was my frame; Far from my native home I came, And manly fought with Simon Byrne; Alas! but liv'd not to return. Reader, take warning by my fate, Lest you should rue your case too late; If you have ever fought before, Determine now to fight no more."
						)
						((& (gEgo onControl: 0) $1000)
							(Print 16 11 #mode 1 #at -1 15 #width 290) ; "Thorp's Corpse."
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said 'look>')
					(cond
						((or (Said '<in/forest') (Said '/forest<hole'))
							(if (gEgo inRect: 103 115 226 177)
								(Print 16 12) ; "There is nothing of importance in the old tree."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/cross')
							(Print 16 13) ; "One of the graves is marked by a cross."
						)
						((Said '/forest')
							(Print 16 14) ; "An old, rotting tree adds appropriate charm to the decrepit cemetery."
						)
						((Said '/hole')
							(for
								((= local7 1))
								(<= local7 gShovelCount)
								((++ local7))
								
								(if
									(and
										(==
											[global138
												(= local5 (* (- local7 1) 3))
											]
											16
										)
										(<
											(egoDist
												doit:
													[global138 (+ local5 1)]
													[global138 (+ local5 2)]
											)
											20
										)
									)
									(= local8 1)
								)
							)
							(cond
								(local8
									(Print 16 15) ; "The hole is empty."
								)
								((gEgo inRect: 103 115 226 177)
									(Print 16 12) ; "There is nothing of importance in the old tree."
								)
								(else
									(Print 800 1) ; "You're not close enough."
								)
							)
							(= local8 0)
						)
						((Said '[<around][/room]')
							(Print 16 16) ; "This run-down, gloomy cemetery gives you the creeps! Many of the old tombstones have fallen over, and the entire place is overgrown with grass and weeds."
						)
					)
				)
				((Said 'dig[/grave,hole]')
					(if (and (gEgo has: 15) (== 0 ((Inv at: 15) loop:))) ; Shovel, Shovel
						(if (> global134 0)
							(if (& (gEgo onControl: 0) $7fff)
								(gEgo setScript: digging)
								(digging changeState: 1)
							else
								(Print 16 17) ; "Try somewhere else. The ground is too hard here."
							)
						else
							(Print 16 18) ; "You don't know what to dig for...yet."
						)
					else
						(Print 16 19) ; "You have nothing to dig with."
					)
				)
			)
		)
	)
)

(instance z1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(= global189 1)
				(zTheme number: 20 loop: 30000 play:)
				(local0 show: setCycle: End self)
				(++ global186)
				((View new:)
					view: 260
					posn: (local0 x:) (local0 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local0
						view: 261
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local0
						view: 261
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(Print 16 20 #at -1 20) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme dispose:)
				)
				(local0 setMotion: 0 view: 260 cel: 11 setCycle: Beg self)
			)
			(5
				(local0 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose:)
				(zTheme number: 21 play:)
				(gEgo view: 36 cel: 0 setCycle: End self)
				(local0 setMotion: Wander)
				(if (gCast contains: local1)
					(local1 setMotion: Wander)
				)
				(if (gCast contains: local2)
					(local2 setMotion: Wander)
				)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 16 21 #at -1 20 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 9)
			)
			(13
				(cls)
				(zTheme dispose:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance z2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (not (gSounds contains: zTheme))
					(zTheme number: 20 loop: 30000 play:)
				)
				(++ global186)
				(local1 show: setCycle: End self)
				((View new:)
					view: 262
					cel: 0
					posn: (local1 x:) (local1 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local1
						view: 263
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local1
						view: 263
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(local1 setMotion: 0 view: 262 cel: 11 setCycle: Beg self)
				(Print 16 20 #at -1 20) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme dispose:)
				)
			)
			(5
				(local1 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose:)
				(zTheme number: 21 play:)
				(gEgo view: 36 cel: 0 setMotion: 0 setCycle: End self)
				(local1 setMotion: Wander)
				(if (gCast contains: local0)
					(local0 setMotion: Wander)
				)
				(if (gCast contains: local2)
					(local2 setMotion: Wander)
				)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 16 21 #at -1 20 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 9)
			)
			(13
				(cls)
				(zTheme dispose:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance z3Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(if (not (gSounds contains: zTheme))
					(zTheme number: 20 loop: 30000 play:)
				)
				(++ global186)
				(local2 show: setCycle: End self)
				((View new:)
					view: 264
					posn: (local2 x:) (local2 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local2
						view: 265
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local2
						view: 265
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(Print 16 20 #at -1 20) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme dispose:)
				)
				(local2 setMotion: 0 view: 264 cel: 11 setCycle: Beg self)
			)
			(5
				(local2 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose:)
				(zTheme number: 21 play:)
				(gEgo view: 36 cel: 0 setMotion: 0 setCycle: End self)
				(local2 setMotion: Wander)
				(if (gCast contains: local0)
					(local0 setMotion: Wander)
				)
				(if (gCast contains: local1)
					(local1 setMotion: Wander)
				)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 16 21 #at -1 20 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 9)
			)
			(13
				(cls)
				(zTheme dispose:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance holeActions of Script
	(properties)

	(method (cue &tmp temp0)
		(= temp0 (local3 cel:))
		(++ temp0)
		(if (>= state 0)
			(local3 cel: temp0)
		else
			(++ state)
		)
	)
)

(instance digging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo
					view: 47
					loop: (& (gEgo loop:) $0001)
					cel: 0
					setCycle: End self
				)
				(= local3 (Prop new:))
				(local3
					posn:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 16)
						else
							(+ (gEgo x:) 16)
						)
						(+ (gEgo y:) 4)
					view: 528
					cel: 0
					setPri: 0
					ignoreActors:
					init:
				)
			)
			(2
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(if (>= gShovelCount 5)
					(Print 16 22) ; "Oh, Oh! You've broken your shovel!"
					(gEgo view: 2 setCycle: Walk)
					((Inv at: 15) loop: 1) ; Shovel
					(self changeState: 0)
					(HandsOn)
				else
					(gEgo cel: 0 setCycle: End self)
				)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(holeActions cue:)
				(if (< (local3 cel:) 6)
					(self changeState: 2)
				else
					(self changeState: 6)
				)
			)
			(6
				(= local5 (* (- (++ gShovelCount) 1) 3))
				(= [global138 local5] gCurRoomNum)
				(= [global138 (+ local5 1)] (local3 x:))
				(= [global138 (+ local5 2)] (local3 y:))
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
				(cond
					(
						(and
							(& (gEgo onControl: 0) $0008)
							(== global134 2)
							((Inv at: 13) ownedBy: 88) ; Gold_Coins
						)
						(local3 setLoop: 1 cel: 2)
						(Print 16 23 #at -1 20 #draw) ; "You dig a small hole at the grave of the old miser. Aha! You have found a bag of gold coins!"
						((Inv at: 13) moveTo: 16) ; Gold_Coins
						(gEgo setScript: getItems)
						(getItems changeState: 1)
						(gEgo get: 13) ; Gold_Coins
						(gGame changeScore: 3)
					)
					(
						(and
							(& (gEgo onControl: 0) $0100)
							(== global134 1)
							((Inv at: 12) ownedBy: 88) ; Silver_Baby_Rattle
						)
						(local3 setLoop: 1 cel: 1)
						(Print 16 24 #at -1 20 #draw) ; "You carefully dig a small hole at the poor baby's grave. What is this?! You have uncovered a silver baby rattle!"
						(gEgo setScript: getItems)
						(getItems changeState: 1)
						(gGame changeScore: 3)
						(gEgo get: 12) ; Silver_Baby_Rattle
					)
					(
						(and
							(& (gEgo onControl: 0) $0004)
							(== global134 4)
							((Inv at: 29) ownedBy: 88) ; Medal
						)
						(local3 setLoop: 1 cel: 3)
						(Print 16 25 #at -1 20 #draw) ; "You dig a small hole at the grave of the Lord of the Manor. Gotcha! You have found an impressive Medal of Honor!"
						((Inv at: 29) moveTo: 16) ; Medal
						(gEgo setScript: getItems)
						(getItems changeState: 1)
						(gEgo get: 29) ; Medal
						(gGame changeScore: 3)
					)
					(else
						(HandsOn)
						(Print 16 26 #at -1 20) ; "You dig a small hole...but find nothing of interest."
					)
				)
			)
		)
	)
)

(instance getItems of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(LookAt gEgo local3)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(2
				(local3 setLoop: 0 cel: 6)
				(= global182 1)
				(gEgo setCycle: Beg self)
			)
			(3
				(= cycles 6)
			)
			(4
				(Print 16 27) ; "You bend down, pick it up, and carry it with you."
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance egoDist of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0
			(Sqrt
				(+
					(*
						(Abs (- (gEgo y:) param2))
						(Abs (- (gEgo y:) param2))
					)
					(*
						(Abs (- (gEgo x:) param1))
						(Abs (- (gEgo x:) param1))
					)
				)
			)
		)
	)
)

