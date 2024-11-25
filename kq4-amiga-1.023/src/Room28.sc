;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room28 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance fallSound of Sound
	(properties
		number 51
		priority 15
	)
)

(instance Room28 of Rm
	(properties
		picture 28
	)

	(method (init)
		(= north 22)
		(= south 4)
		(= east 29)
		(= west 27)
		(= horizon 126)
		(= gIndoors 0)
		(HandsOn)
		(gEgo edgeHit: EDGE_NONE illegalBits: $8000)
		(if (== (gGSound state:) 3)
			(gGSound play: -15536)
		)
		(super init:)
		(if gNight
			(gCurRoom overlay: 128)
		)
		(self setRegions: 508) ; Forest_Region
		(Load rsVIEW 17)
		(Load rsVIEW 21)
		(Load rsSOUND 51)
		(= local4 (View new:))
		(if gNight
			(local4
				view: 600
				loop: 0
				cel: 0
				setPri: 9
				posn: 289 137
				ignoreActors:
				init:
				stopUpd:
			)
			(gEgo observeControl: 16384)
		else
			(local4
				view: 600
				loop: 1
				cel: 0
				ignoreActors: 1
				setPri: 9
				posn: 284 131
				init:
				stopUpd:
			)
		)
		(switch gPrevRoomNum
			(22
				(gEgo posn: 82 128)
			)
			(27
				(if (<= (gEgo y:) horizon)
					(gEgo posn: 2 (+ horizon 2))
				else
					(gEgo posn: 2 (gEgo y:))
				)
			)
			(29
				(if (<= (gEgo y:) 156)
					(gEgo x: 318 y: 149)
				else
					(gEgo posn: 317 187)
				)
			)
			(4
				(gEgo posn: 158 187)
			)
			(55
				(gEgo x: 290 y: 134)
			)
			(0
				(gEgo x: 88 y: 160)
			)
		)
		(gEgo view: 2 xStep: 3 yStep: 2 init:)
		(gEgo y: (| (gEgo y:) $0001))
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (& (= local0 (gEgo onControl:)) $0040)
			(gCurRoom newRoom: 55)
		)
		(if
			(and
				(!= local0 local3)
				(== (gCurRoom script:) 0)
				(== gCurRoomNum gNewRoomNum)
			)
			(= local3 local0)
			(if (& local0 $0004)
				(self setScript: fallSouth)
				(gCurRoom east: 0)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(if (not gNight)
				(if (Said 'look>')
					(cond
						((Said '/door')
							(Print 28 0) ; "The door is wide open."
						)
						((Said '<in[/mine]')
							(if (gEgo inRect: 269 135 295 142)
								(Print 28 1) ; "You look inside, but can make out no details."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/mine,hill')
							(Print 28 2) ; "The crude mine is carved into a small hill. Its solid, wooden door is propped open."
						)
						((Said '[<around][/room]')
							(Print 28 3) ; "You see a crude mine shaft in the midst of this forest of pine trees."
						)
					)
				)
				(if (Said '/door>')
					(cond
						((Said 'close,close')
							(Print 28 4) ; "You shouldn't close it."
						)
						((Said 'open,bang')
							(Print 28 5) ; "The door is already open."
						)
					)
				)
			else
				(if (Said '/door,padlock,latch>')
					(cond
						((Said 'break/door')
							(Print 28 6) ; "You could never do that."
						)
						((Said 'bang/door')
							(if (gEgo inRect: 276 131 298 143)
								(Print 28 7) ; "You knock on the door, but receive no answer."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said 'open/door')
							(Print 28 8) ; "You can't. It's closed and padlocked."
						)
						((Said 'unlatch,detach,get')
							(Print 28 9) ; "You can't. You don't have the key."
						)
					)
				)
				(if (Said 'look>')
					(cond
						((Said '/door')
							(Print 28 10) ; "The door is closed and padlocked."
						)
						((Said '/mine,hill')
							(Print 28 11) ; "The crude mine is carved into a small hill. Its solid, wooden door is closed and padlocked."
						)
						((Said '[<around][/room]')
							(Print 28 3) ; "You see a crude mine shaft in the midst of this forest of pine trees."
						)
					)
				)
			)
		)
	)
)

(instance fallSouth of Script
	(properties)

	(method (init)
		(gEgo viewer: 0)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound init: play:)
				(if (< (gEgo x:) 265)
					(= local2 20)
				else
					(= local2 30)
				)
				(if (> (+ (gEgo y:) local2) 188)
					(= local1 188)
				else
					(= local1 (+ (gEgo y:) local2))
				)
				(gEgo
					view: 17
					setStep: 6 6
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) local1 self
				)
			)
			(1
				(gEgo
					xStep: 3
					yStep: 2
					view: 21
					loop: 2
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo view: 21 loop: 2 setCycle: Beg self)
			)
			(3
				(gCurRoom setScript: 0)
				(gEgo illegalBits: $8000 setCycle: Walk view: 2)
				(if gNight
					(gEgo observeControl: 16384)
				)
				(gCurRoom east: 29)
				(HandsOn)
			)
		)
	)
)

