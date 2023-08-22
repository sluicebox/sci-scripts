;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room17 0
)

(synonyms
	(kiss kiss embrace)
	(ghoul ghoul ghoul man ghoul ghoul)
)

(local
	local0
)

(instance zTheme of Sound
	(properties
		number 21
		priority 15
	)
)

(instance doorSound of Sound
	(properties
		priority 15
	)
)

(instance door of Prop
	(properties)

	(method (cue)
		(if (!= (door cel:) (door lastCel:))
			(self setCycle: End self)
		else
			(HandsOn)
			(gCurRoom newRoom: 68)
		)
	)
)

(instance Room17 of Rm
	(properties
		picture 17
	)

	(method (init)
		(= north 11)
		(= south 23)
		(= east 18)
		(= west 16)
		(= horizon 100)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(self setRegions: 508) ; Forest_Region
		(if (== (gGSound state:) 3)
			(gGSound play: -15536)
		)
		(super init:)
		(if gNight
			(gCurRoom overlay: 117)
		)
		(if (and gNight (not (gEgo has: 7))) ; Obsidian_Scarab
			(Load rsVIEW 270)
			(Load rsVIEW 36)
			(Load rsVIEW 35)
			(= local0 (Act new:))
			(local0
				view: 270
				cel: 0
				loop: 0
				posn: 146 145
				setPri: 10
				illegalBits: 0
				ignoreActors:
				setScript: z6Actions
				init:
				hide:
			)
		)
		(door view: 610 loop: 0 cel: 0 posn: 147 144 stopUpd: init:)
		(switch gPrevRoomNum
			(16
				(if (<= (gEgo y:) 120)
					(gEgo x: 1 y: 120)
				else
					(gEgo x: 1)
				)
			)
			(18
				(if (<= (gEgo y:) 120)
					(gEgo x: 318 y: 120)
				else
					(gEgo x: 318)
				)
			)
			(23
				(gEgo posn: (gEgo x:) 188)
			)
			(11
				(if (< (gEgo x:) 160)
					(gEgo x: 42 y: (+ horizon (gEgo yStep:) 1))
				else
					(gEgo x: 267 y: (+ horizon (gEgo yStep:) 1))
				)
			)
			(68
				(gEgo loop: 2 x: 161 y: 151)
			)
			(0
				(gEgo x: 290 y: 160)
			)
		)
		(gEgo setPri: -1 view: 2 xStep: 3 yStep: 2 init:)
	)

	(method (newRoom newRoomNumber)
		(if (== (gEgo view:) 2)
			(HandsOn)
			(gEgo setPri: -1)
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look/around')
						(Said 'look/room')
						(Said 'look[<around][/!*]')
					)
					(Print 17 0) ; "Indeed, this is a spooky old house! It looks as if no one has lived here for many years. Flanking the old house on both sides is a run-down cemetery. A thick forest looms all around."
				)
				((Said 'look>')
					(cond
						((Said '/grave,gravestone,gravestone')
							(Print 17 1) ; "The graves are in the cemetery."
						)
						((Said '/fence,wall')
							(Print 17 2) ; "An old, crumbling stone wall surrounds the neglected cemetery."
						)
						((Said '/cottage')
							(Print 17 3) ; "This is not a pleasant house; in fact, it's downright scary! It looks old and abandoned, and badly in need of tender-loving-care. To make matters worse, it sits right in the middle of an old cemetery!"
						)
						((Said '/cemetery')
							(Print 17 4) ; "A decrepit and over-grown cemetery surrounds the old house."
						)
						((Said '/door')
							(Print 17 5) ; "This is a finely-carved, wooden door."
						)
						((Said '/window')
							(cond
								(
									(or
										(gEgo inRect: 96 142 128 148)
										(gEgo inRect: 194 142 229 148)
									)
									(Print 17 6) ; "You peek through the window, but can make out no details."
								)
								(
									(or
										(gEgo inRect: 70 151 124 157)
										(gEgo inRect: 193 154 260 159)
									)
									(Print 17 7) ; "The bushes are too tall! Go up by the door."
								)
								(else
									(Print 800 1) ; "You're not close enough."
								)
							)
						)
						((Said '/stair')
							(Print 17 8) ; "Wide stone steps lead up to the front door of the spooky old house."
						)
						((or (Said 'look/bush') (Said 'look/bush'))
							(Print 17 9) ; "Overgrown shrubs front the old house."
						)
					)
				)
				((Said 'break/window')
					(Print 17 10) ; "It looks like many of the windows are already broken!"
				)
				((Said 'break/door')
					(Print 17 11) ; "You could never do that."
				)
				((Said 'open/door')
					(if (gEgo inRect: 139 140 173 153)
						(HandsOff)
						(gEgo loop: 3 setPri: 11)
						(doorSound number: 300 init: loop: 1 play: door)
						(door setCycle: End)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'close/door')
					(Print 17 12) ; "The door is closed."
				)
				((Said 'open/window')
					(Print 17 13) ; "The windows do not open."
				)
				((Said 'unlatch/door')
					(Print 17 14) ; "The door is already unlocked."
				)
				((Said 'bang/door')
					(if (gEgo inRect: 139 140 173 153)
						(Print 17 15) ; "With trepidation, you rap on the door. Not surprisingly, nobody answers."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance z6Actions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 141 146 175 149) (== state 0))
			(HandsOff)
			(z6Actions changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local0 show: setLoop: 0 cel: 255 setCycle: End self)
			)
			(2
				(local0 hide:)
				(zTheme init: play: self)
				(gEgo view: 35 cel: 255 setCycle: End self)
			)
			(3
				(local0 view: 270 show: cycleSpeed: 1 setCycle: Beg)
				(gEgo view: 36 cel: 255 setMotion: 0 setCycle: End self)
			)
			(4
				(gEgo view: 46 cel: 255 setCycle: End self)
			)
			(5
				(local0 hide:)
				(= global120 (Print 17 16 #at -1 20 #dispose)) ; "To wander forever is now your fate."
				(gEgo
					view: 45
					x: 160
					setCycle: Walk
					setMotion: MoveTo 160 230
				)
			)
			(6
				(= gDeathFlag 1)
			)
		)
	)
)

