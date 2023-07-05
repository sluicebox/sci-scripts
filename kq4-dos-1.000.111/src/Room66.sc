;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room66 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Room66 of Rm
	(properties
		picture 66
		style 16
	)

	(method (init)
		(Load rsVIEW 512)
		(Load rsVIEW 44)
		(Load rsVIEW 42)
		(Load rsVIEW 41)
		(Load rsVIEW 4)
		(Load rsSCRIPT 991)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		((View new:) view: 512 loop: 1 cel: 0 posn: 208 80 setPri: 4 addToPic:)
		((Prop new:)
			view: 512
			loop: 0
			posn: 206 65
			setPri: 3
			init:
			setCycle: Fwd
		)
		(if (== ((gInventory at: 15) owner:) 66) ; Shovel
			((= local0 (View new:))
				view: 512
				loop: 2
				cel: 0
				posn: 194 123
				init:
				stopUpd:
			)
		)
		(if (or (== gPrevRoomNum 67) (== gPrevRoomNum 0))
			(gEgo
				illegalBits: -16384
				posn: 240 128
				view: 4
				xStep: 4
				yStep: 1
				init:
				setPri: -1
			)
			(= local1 1)
			(gEgo observeBlocks: stair1)
		)
		(if (== gPrevRoomNum 61)
			(gEgo
				illegalBits: -32768
				view: 4
				xStep: 4
				setPri: 7
				yStep: 1
				posn: 102 38
				baseSetter: (ScriptID 0 1) ; smallBase
				init:
			)
			(= local1 0)
		)
		(gEgo observeBlocks: stair2)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 67)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gCurRoom newRoom: 61)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0004)
				(not local1)
				(!= (self script:) stairTrip)
			)
			(self setScript: stairTrip)
		)
		(if (& (gEgo onControl: 1) $0800)
			(if (> (gEgo heading:) 180)
				(= local1 0)
				(if (gEgo blocks:)
					(gEgo ignoreBlocks: stair1)
				)
				(gEgo
					illegalBits: -32768
					baseSetter: (ScriptID 0 1) ; smallBase
					setPri: 12
				)
			else
				(= local1 1)
				(gEgo
					observeBlocks: stair1
					illegalBits: -16384
					baseSetter: 0
					setPri: -1
				)
			)
		)
		(cond
			(
				(and
					(gEgo inRect: 183 150 205 168)
					(& (gEgo onControl:) $0800)
					local1
				)
				(gEgo setPri: 12)
			)
			(
				(and
					local1
					(not (gEgo inRect: 183 150 205 168))
					(== (gEgo priority:) 12)
				)
				(gEgo setPri: -1)
			)
		)
		(if (& (gEgo onControl: 1) $0400)
			(if (or (< (gEgo heading:) 90) (> (gEgo heading:) 270))
				(gEgo setPri: 7)
			else
				(gEgo setPri: 12)
			)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '/stair')
								(Print 66 0) ; "The steps are narrow, steep, and spiral upwards."
							)
							((Said '/door')
								(Print 66 1) ; "The secret door opens into the parlor."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 66 2) ; "You see nothing of interest on the floor."
							)
							((Said '/wall')
								(Print 66 3) ; "You see nothing of interest on the walls."
							)
							((Said '/torch')
								(Print 66 4) ; "A torch burns on the wall."
							)
							((Said '<up')
								(Print 66 5) ; "The spiral stairs go way up!"
							)
							((Said '[<around][/room,tower]')
								(Print
									(Format ; "You have found a secret tower! Narrow steps spiral dizzingly upward. %s"
										@global300
										66
										6
										(if (== ((gInventory at: 15) owner:) 66) ; Shovel
											{You notice a shovel leaning against the wall.}
										else
											{ }
										)
									)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said '*/stair')
						(Print 66 7) ; "Just climb them."
					)
					((Said 'get/shovel')
						(if
							(and
								(== ((gInventory at: 15) owner:) 66) ; Shovel
								(gCast contains: local0)
							)
							(if (< (gEgo distanceTo: local0) 15)
								(gEgo get: 15) ; Shovel
								(= global182 1)
								(gGame changeScore: 2)
								(local0 dispose:)
							else
								(Print 800 1) ; "You're not close enough."
							)
						else
							(Print 66 8) ; "What shovel?"
						)
					)
					((Said 'get/torch')
						(Print 66 9) ; "The torch is firmly attached to the wall."
					)
					((Said 'close/door')
						(Print 66 10) ; "You don't need to close it."
					)
					((Said 'open/door')
						(Print 66 11) ; "The secret door is already open."
					)
				)
			)
		)
	)
)

(instance stairTrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (< (gEgo y:) 90)
					(= local2 1)
				)
				(self cue:)
			)
			(1
				(gEgo
					view: 44
					moveSpeed: 0
					setMotion: 0
					setLoop: 0
					setCycle: End self
				)
				((Sound new:) number: 51 loop: 1 play:)
			)
			(2
				(gEgo setPri: 11)
				(RedrawCast)
				(gEgo
					setStep: 10 10
					setLoop: 2
					setCycle: Fwd
					setMotion: JumpTo 185 142 self
				)
			)
			(3
				(if local2
					(gEgo view: 42 loop: 0 cel: 0 setPri: 8)
					((ScriptID 0 4) setCycle: self 2) ; timer1
				else
					(= local1 1)
					(gEgo observeBlocks: stair1)
					(gEgo
						view: 41
						setPri: -1
						cel: 0
						setLoop: 0
						setCycle: End self
					)
				)
			)
			(4
				(if local2
					(ShakeScreen 10)
					(= seconds 3)
				else
					(gEgo
						view: 4
						xStep: 4
						yStep: 1
						setCycle: Walk
						setLoop: -1
						setPri: -1
						illegalBits: -16384
						baseSetter: 0
						ignoreActors: 0
					)
					(= state -1)
					(HandsOn)
					(client setScript: 0)
				)
			)
			(5
				(= gDeathFlag 1)
			)
		)
	)
)

(instance stair1 of Blk
	(properties
		top 116
		left 147
		bottom 117
		right 159
	)
)

(instance stair2 of Blk
	(properties
		top 194
		left 198
		bottom 149
		right 151
	)
)

