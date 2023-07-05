;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	TrollEnter 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1)
	(if param1
		((= local0 (View new:))
			view: 800
			posn: 108 133
			init:
			setPri: 15
			stopUpd:
		)
	else
		(local0 dispose:)
		(= local0 0)
	)
)

(instance TrollEnter of Rm
	(properties
		picture 71
		style 16
	)

	(method (init)
		(Load rsVIEW 800)
		(Load rsVIEW 511)
		(Load rsVIEW 40)
		(super init:)
		(= south 74)
		(self setRegions: 605) ; regTroll
		(= gIndoors 1)
		((= local2 (Prop new:))
			view: 511
			loop: 0
			cel: 0
			posn: 72 122
			stopUpd:
			init:
		)
		(if (== ((gInventory at: 23) owner:) 71) ; Bone
			((= local1 (Prop new:))
				view: 511
				ignoreActors: 1
				loop: 0
				cel: 1
				posn: 72 117
				stopUpd:
				init:
			)
		)
		(gEgo view: 4 xStep: 4 yStep: 1)
		(switch gPrevRoomNum
			(72 ; TrollCave72
				(gEgo posn: 208 105)
			)
			(74 ; TrollCave74
				(gEgo posn: 170 184)
			)
			(else
				(gEgo posn: 78 113)
				(= gTrollChasing 0)
				(if (not (proc0_22))
					(localproc_0 1)
				)
			)
		)
		(gEgo priority: (CoordPri (gEgo y:)) init:)
		(if (proc0_22)
			(Notify 605 1)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl: 0) $0040)
				(gCurRoom newRoom: 70) ; Room_70
			)
			((& (gEgo onControl: 0) $0020)
				(gCurRoom newRoom: 72) ; TrollCave72
			)
		)
		(cond
			((and local0 (proc0_22))
				(localproc_0 0)
			)
			((and (not local0) (not (proc0_22)))
				(localproc_0 1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 70) ; Room_70
			((ScriptID 605) keep: 0) ; regTroll
			(= global189 0)
			(gSounds eachElementDo: #dispose)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((or (Said '/falls') (Said '<out'))
							(Print 71 0) ; "Outside the cave, you see the waterfall."
						)
						((Said '/heap')
							(Print 71 1) ; "You see a pile of bones by the cave entrance."
						)
						(
							(and
								(not (gEgo has: 23)) ; Bone
								(or
									(Said '/bone')
									(Said '/dirt')
									(Said '<down')
								)
							)
							(Print 71 1) ; "You see a pile of bones by the cave entrance."
						)
						((or (Said '<around') (Said '/room,cave'))
							(Print
								(Format ; "This is the darkest cave you've ever seen! %s"
									@global300
									71
									2
									(if (proc0_22)
										{Even the lantern does little good.}
									else
										{ }
									)
								)
							)
							(if (not (gEgo has: 23)) ; Bone
								(Print 71 3) ; "By the light of the cave entrance, you can see a pile of bones."
							)
						)
					)
				)
				((Said 'get/bone')
					(cond
						((!= ((gInventory at: 23) owner:) 71) ; Bone
							(Print 71 4) ; "You don't need another one."
						)
						(
							(and
								(< (gEgo distanceTo: local1) 15)
								(== ((gInventory at: 23) owner:) 71) ; Bone
							)
							(gEgo get: 23) ; Bone
							(gEgo setScript: getDown)
							(local1 hide:)
							(= global182 1)
							(gGame changeScore: 2)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance getDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 (gEgo view:))
				(gEgo
					setMotion: 0
					view: 40
					cel: 0
					loop: (if (< (gEgo heading:) 180) 0 else 1)
					setCycle: End
				)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo view: local3 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

