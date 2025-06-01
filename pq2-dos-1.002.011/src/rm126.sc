;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 126)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm126 0
)

(local
	local0
	local1
	local2
	[local3 4]
	local7
	local8
	[local9 100]
)

(instance rm126 of Rm
	(properties
		picture 70
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			view: (if (not global204) 0 else 6)
			x: (if (== gPrevRoomNum 125) 12 else 310)
			y: (if (<= (gEgo y:) 115) 100 else 140)
			init:
		)
		(HandsOn)
		((= local0 (Prop new:))
			view: 92
			loop: 0
			cel: 0
			posn: 305 115
			setPri: 1
			ignoreActors: 1
			init:
			stopUpd:
		)
		((Prop new:)
			view: 92
			loop: 2
			cel: 0
			posn: 114 116
			setPri: 1
			setCycle: Fwd
			ignoreActors: 1
			init:
		)
		((View new:)
			view: 92
			loop: 4
			cel: (if (gEgo has: 32) 0 else 1) ; gas_mask
			ignoreActors:
			posn: 166 85
			setPri: 1
			init:
			addToPic:
		)
		((= local1 (Prop new:))
			view: 92
			loop: 3
			cel: 0
			ignoreActors:
			posn: 166 85
			setPri: 2
			init:
			stopUpd:
		)
		((= [local3 0] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 237 130
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local3 1] (Prop new:))
			view: 99
			loop: 0
			cel: 1
			posn: 120 126
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local3 2] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 133 173
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local3 3] (Prop new:))
			view: 99
			loop: 0
			cel: 0
			posn: 192 125
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local3 0] stopUpd:)
			([local3 1] stopUpd:)
		)
		(if (< global110 30)
			([local3 2] stopUpd:)
			([local3 3] stopUpd:)
		)
		(= local7 0)
		(gRatObj
			name: 7
			posn: 287 57
			setLoop: 2
			ignoreActors: 1
			init:
			setMotion: MoveTo -100 57 gRatObj
		)
		(gLightObj posn: 167 54 ignoreActors: 1 init: stopUpd:)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo x:) 5)
				(gCurRoom newRoom: 125)
			)
			((>= (gEgo x:) 315)
				(gCurRoom newRoom: 127)
			)
			((not (gEgo inRect: 292 92 303 108))
				(= local7 0)
			)
			((not local7)
				(= local7 1)
				(if (== (Random 0 4) 3)
					(= global139 1)
					(gEgo setScript: downTheDrain)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'get/mask')
						(cond
							((gEgo has: 32) ; gas_mask
								(Print 126 0) ; "You already have one."
							)
							((not local8)
								(Print 126 1) ; "You don't see a gas mask here."
							)
							(else
								(Print 126 2) ; "You take the last gas mask from the cabinet."
								(gEgo get: 32) ; gas_mask
								((View new:)
									view: 92
									loop: 4
									cel: 0
									ignoreActors:
									posn: 166 85
									setPri: 1
									init:
									addToPic:
								)
								(SetScore 4)
							)
						)
					)
					((Said 'open/cabinet,compartment,door')
						(cond
							(local8
								(Print 126 3) ; "It already is."
							)
							((gEgo inRect: 145 90 196 105)
								(cabinetScript changeState: 1)
							)
							(else
								(proc0_7) ; "You're not close enough."
							)
						)
					)
					((Said 'look/mask')
						(cond
							((gEgo has: 32) ; gas_mask
								(event claimed: 0)
							)
							((not local8)
								(Print 126 1) ; "You don't see a gas mask here."
							)
							(else
								(Print 126 4) ; "It looks like your standard sewer gas mask."
							)
						)
					)
					((Said 'look/cabinet,compartment')
						(cond
							((not local8)
								(Print 126 5) ; "The cabinet is closed."
							)
							((IsItemAt 32) ; gas_mask
								(Print 126 6) ; "You see a gas mask in the cabinet."
							)
							(else
								(Print 126 7) ; "The cabinet is empty."
							)
						)
					)
					((Said 'look[<at,around][/(!*,chamber)]')
						(Print 126 8) ; "You see walkways and grates that lead around the dark and smelly sewer."
						(Print
							(Format ; "On the wall, you see a cabinet that is %s."
								@local9
								126
								9
								(cond
									((not local8) { closed})
									((IsItemAt 32) {open with a gas mask in it}) ; gas_mask
									(else { open and empty})
								)
							)
						)
					)
					((Said 'look/wall')
						(Print 126 10) ; "On one wall is a cabinet."
					)
					((Said 'close/cabinet,compartment,door')
						(cond
							((not local8)
								(Print 126 3) ; "It already is."
							)
							((gEgo inRect: 145 94 196 105)
								(cabinetScript changeState: 3)
							)
							(else
								(proc0_7) ; "You're not close enough."
							)
						)
					)
					((Said '(drop<back),replace/mask')
						(if (gEgo has: 32) ; gas_mask
							(Print 126 11) ; "You will find the mask useful."
						else
							(proc0_9) ; "You don't have it."
						)
					)
				)
			)
		)
	)
)

(instance cabinetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local1 setCycle: End self)
				(= local8 1)
			)
			(2
				(local1 stopUpd:)
			)
			(3
				(local1 setCycle: Beg self)
				(= local8 0)
			)
			(4
				(local1 stopUpd:)
			)
		)
	)
)

(instance downTheDrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global139 1)
				(gEgo
					view: 92
					setLoop: 1
					cel: 0
					yStep: 1
					illegalBits: 0
					setMotion: MoveTo 304 110
					setCycle: CT 2 1
				)
				(local0 setCycle: CT 3 1 self)
				(gContinuousMusic stop: number: 24 loop: 1 priority: 12 play:)
			)
			(1
				(gEgo yStep: 3 setMotion: MoveTo 304 115 setCycle: CT 4 1)
				(local0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo setMotion: MoveTo 304 125 setCycle: CT 7 1)
				(local0 setCycle: CT 10 1)
				(= cycles 10)
			)
			(3
				(Print 126 12) ; "You step into the path of high pressure water being released from the surface..."
				(Print 126 13) ; "And you're swept into the sewer . Your head hits hard during the fall, rendering you unconscious..."
				(Print 126 14) ; "Unfortunately for you, the sewer does the rest."
				(gEgo dispose:)
				(EgoDead 126 15) ; "You drown in the sewer because of an unfortunate accident. Next time, try to minimize the chance of it happening again."
			)
		)
	)
)

