;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room7 0
)

(synonyms
	(fisherman fisherman fisherman fisherman man)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2]
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance fallSound of Sound
	(properties
		number 51
	)
)

(instance dizzySound of Sound
	(properties
		number 80
	)
)

(instance doorSound of Sound
	(properties
		number 300
	)
)

(instance fisherCage of Cage
	(properties
		top 137
		bottom 149
		right 231
	)
)

(instance door of Prop
	(properties)

	(method (cue)
		(if (!= (door cel:) (door lastCel:))
			(self setCycle: End self)
		else
			(HandsOn)
			(gCurRoom newRoom: 42)
		)
	)
)

(instance waves of List
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance Room7 of Rm
	(properties
		picture 7
	)

	(method (init)
		(= north 1)
		(= south 13)
		(= east 8)
		(= west 95)
		(= horizon 86)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(if gNight
			(gCurRoom overlay: 107)
		)
		(self setRegions: 503 504) ; beachReg, Gull_Region
		(Load rsVIEW 2)
		(Load rsVIEW 5)
		(Load rsVIEW 6)
		(Load rsVIEW 7)
		(Load rsVIEW 8)
		(Load rsVIEW 17)
		(Load rsVIEW 19)
		(Load rsVIEW 18)
		(Load rsSOUND 80)
		(Load rsSOUND 51)
		(Load rsSOUND 300)
		(wave1
			isExtra: 1
			view: 667
			loop: 0
			cel: 0
			posn: 98 84
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			isExtra: 1
			view: 667
			loop: 1
			cel: 0
			posn: 97 109
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			isExtra: 1
			view: 667
			loop: 2
			cel: 0
			posn: 79 136
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(= local8 (Prop new:))
		(= local9 (Prop new:))
		(= local10 (Prop new:))
		(local8
			isExtra: 1
			view: 667
			loop: 3
			cel: 0
			posn: 11 168
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 2
			init:
		)
		(local9
			isExtra: 1
			view: 667
			loop: 5
			cel: 0
			posn: 103 166
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 2
			init:
		)
		(local10
			isExtra: 1
			view: 667
			loop: 4
			cel: 0
			posn: 117 177
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 2
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(= local5 (Prop new:))
		(local5
			isExtra: 1
			view: 625
			loop: 1
			cel: 0
			x: 200
			y: 19
			setCycle: Fwd
			cycleSpeed: 1
			init:
		)
		(door
			view: 601
			loop: 0
			cel: 0
			x: 220
			y: 139
			setPri: 9
			ignoreActors:
			init:
			stopUpd:
		)
		(if (== global116 2)
			(if
				(<
					(= local12
						(+
							(* 3600 (- global160 global199))
							(* 60 (- global159 global197))
							(- global158 global198)
						)
					)
					40
				)
				(= local4 (Act new:))
				(local4 view: 230)
				(cond
					((<= local12 12)
						(= local13 40)
					)
					((< local12 20)
						(= local13 120)
					)
					(else
						(= local13 166)
					)
				)
				(local4
					posn: local13 144
					setPri: 13
					loop: 0
					setCycle: Walk
					xStep: 3
					yStep: 1
					setScript: fishWalkHouse
					init:
				)
				(local4 baseSetter: (ScriptID 0 1)) ; smallBase
			else
				(= global116 3)
			)
		)
		(gEgo observeControl: -32768 16384 1024)
		(if (<= (gEgo y:) (+ horizon 1))
			(gEgo y: (+ horizon 2))
		)
		(if (or (== gPrevRoomNum 0) (== gPrevRoomNum 8) (== (gEgo view:) 2))
			(= global105 0)
		)
		(switch global105
			(0
				(switch gPrevRoomNum
					(13
						(if (< (gEgo x:) 164)
							(gEgo posn: 170 188)
						else
							(gEgo posn: 304 187)
						)
					)
					(1
						(if (> (gEgo x:) 277)
							(gEgo posn: 143 (+ horizon 2))
						else
							(gEgo posn: 113 (+ horizon 2))
						)
					)
					(42
						(gEgo
							view: 2
							loop: 1
							posn: 212 140
							xStep: 3
							yStep: 2
						)
					)
					(95
						(if (== global107 9)
							(gEgo
								view: 2
								illegalBits: $8000
								observeControl: 128 1024
								posn: 1 143
							)
						else
							(gEgo posn: 1 (gEgo y:))
						)
					)
					(8
						(if (< (gEgo y:) 125)
							(gEgo x: 280)
						else
							(gEgo x: 317)
						)
						(if (<= (gEgo y:) (+ horizon 1))
							(gEgo y: (+ horizon 2))
						)
						(if (gEgo inRect: 193 129 319 157)
							(gEgo setPri: 12)
						)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(13
						(gEgo posn: 189 185)
					)
					(1
						(gEgo posn: 93 (+ horizon 2))
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(13
						(gEgo posn: 137 185)
					)
					(1
						(gEgo posn: 88 (+ horizon 2))
					)
				)
			)
			(3
				(switch gPrevRoomNum
					(13
						(gEgo posn: 105 184)
					)
					(1
						(gEgo posn: 73 (+ horizon 2))
					)
				)
			)
			(4
				(switch gPrevRoomNum
					(95
						(gEgo x: 2)
					)
					(13
						(gEgo posn: 42 184)
					)
					(1
						(gEgo posn: 20 (+ horizon 2))
					)
				)
			)
		)
		(gEgo xStep: 3 yStep: 2 init: viewer: water)
		(gEgo y: (& (gEgo y:) $fffe))
		(fisherCage init:)
	)

	(method (doit)
		(super doit:)
		(if (not (gEgo inRect: -5 135 174 153))
			(= global107 0)
		)
		(= local2 (gEgo onControl:))
		(if (and (gEgo inRect: -3 0 27 189) (!= global107 9))
			(gEgo view: 8)
		)
		(if (and (& (gEgo onControl: 1) $0040) (== global107 9))
			(gEgo observeControl: 16384)
			(gEgo ignoreControl: 128)
			(gEgo setPri: -1)
			(= global107 0)
		)
		(if (and (& (gEgo onControl: 1) $0020) (!= global107 9))
			(gEgo setPri: 13)
			(gEgo illegalBits: $8000 observeControl: 1024)
			(gEgo observeControl: 128)
			(= global107 9)
		)
		(if (== (gCurRoom script:) 0)
			(if (!= global107 9)
				(cond
					((gEgo inRect: 103 157 219 189)
						(gEgo setPri: 15)
					)
					((gEgo inRect: 193 129 319 157)
						(gEgo setPri: 12)
					)
					((gEgo inRect: 80 125 157 158)
						(gEgo setPri: 8)
					)
					(else
						(gEgo setPri: -1)
					)
				)
			)
			(cond
				(
					(and
						(== global105 0)
						(& local2 $1000)
						(> (gEgo heading:) 135)
					)
					(self setScript: fallRocks)
				)
				(
					(and
						(== global105 0)
						(& local2 $1000)
						(<= (gEgo heading:) 135)
					)
					(gEgo setPri: -1)
				)
				((& local2 $2000)
					(if
						(and
							(!= global107 9)
							(> (gEgo heading:) 90)
							(< (gEgo heading:) 270)
						)
						(gEgo setPri: -1)
					else
						(gEgo setPri: 12)
					)
				)
				((& local2 $0100)
					(if (!= global107 9)
						(if
							(and
								(> (gEgo heading:) 90)
								(< (gEgo heading:) 270)
							)
							(gEgo setPri: 12)
						else
							(gEgo setPri: -1)
						)
					)
				)
				((== global107 9)
					(cond
						((& local2 $0010)
							(self setScript: fallNorth)
						)
						((& local2 $0004)
							(self setScript: fallSouth)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(gEgo setPri: -1)
		(waves dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(gEgo setPri: -1 illegalBits: $8000)
		(if (== global116 2)
			(= global116 3)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'get/fisherman')
					(if (== global116 2)
						(Print 7 0) ; "You couldn't get the fisherman."
					else
						(Print 7 1) ; "What fisherman?"
					)
				)
				((Said 'get/pole')
					(if (gCast contains: local4)
						(Print 7 2) ; "It's his, Rosella!"
					else
						(Print 7 3) ; "You don't see one here."
					)
				)
				((Said 'rob/pole')
					(if (gCast contains: local4)
						(Print 7 4) ; "You're not a thief, Rosella!"
					else
						(Print 7 3) ; "You don't see one here."
					)
				)
				((Said 'kiss')
					(if (== global116 2)
						(Print 7 5) ; "You think, for a moment, that it might help, but then change your mind."
					else
						(Print 7 6) ; "Who?"
					)
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(if (== global116 2)
								(Print 7 7) ; "The fisherman ignores you."
							else
								(Print 7 8) ; "To whom?"
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
				((Said 'help/fisherman')
					(Print 7 9) ; "How can you do that, Rosella?"
				)
				(
					(or
						(Said 'look/around')
						(Said 'look/room')
						(Said 'look[<around][/!*]')
					)
					(Print 7 10) ; "A poor fisherman's shanty adorns this part of the coastline. A pier stretches, from the house, out into the ocean to the west. You see a pretty meadowland off to the east."
				)
				((Said 'look>')
					(cond
						((Said '/anchor')
							(Print 7 11) ; "An old, rusted anchor leans against the wall of the house."
						)
						((Said '/cottage')
							(Print 7 12) ; "The fisherman's shack looks badly in need of repair, as the sun, wind, and salt spray have taken their toll. From the house, an old pier leads out into the ocean."
						)
						((Said '<under/dock')
							(Print 7 13) ; "There is only ocean under the old pier."
						)
						((Said '/door')
							(Print 7 14) ; "This is a plain wooden door."
						)
						((Said '/window')
							(if
								(or
									(gEgo inRect: 185 126 207 140)
									(gEgo inRect: 230 141 256 153)
									(gEgo inRect: 270 140 315 151)
									(gEgo inRect: 204 129 233 148)
								)
								(Print 7 15) ; "You peek through the window, but can make out no details."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/dock')
							(Print 7 16) ; "The old, worn pier juts out into the ocean from the weather-beaten house."
						)
						((Said '/fisherman')
							(if (== global116 2)
								(Print 7 17) ; "You see a grizzled old fisherman on the pier. Apparently, he isn't having any luck today."
							else
								(Print 7 3) ; "You don't see one here."
							)
						)
						((Said '/grass')
							(Print 7 18) ; "A pretty meadow leads eastward from here."
						)
					)
				)
				((Said 'get/anchor')
					(Print 7 19) ; "It's too heavy for you to move."
				)
				((Said 'break/window')
					(Print 7 20) ; "That's vandalism!"
				)
				((Said 'break/door')
					(Print 7 21) ; "You could never do that."
				)
				((Said 'open/window')
					(Print 7 22) ; "The windows do not open."
				)
				((Said 'close/door')
					(Print 7 23) ; "The door is already closed."
				)
				(
					(Said
						'talk[/fisherman,fisherman,fisherman,fisherman,fisherman]'
					)
					(if (== global116 2)
						(Print 7 24) ; "You say a few words to the old fisherman. However, he must have other things on his mind as he seems to ignore you."
					else
						(event claimed: 0)
					)
				)
				((Said 'unlatch/door')
					(if (not gNight)
						(Print 7 25) ; "The door is already unlocked."
					else
						(Print 7 26) ; "You can't. It's locked and you don't have the key."
					)
				)
				((Said 'bang/door')
					(if (gEgo inRect: 204 129 233 148)
						(if (not gNight)
							(Print 7 27) ; "You knock loudly on the shanty door. A woman's voice answers, "Jest come on in!""
						else
							(Print 7 28) ; "You knock loudly on the shanty door. From inside, a man's voice calls out, "D'ya know what TIME it is?! GO AWAY!!""
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'open/door')
					(cond
						((!= (door cel:) 0)
							(Print 7 29) ; "Try waiting until it closes."
						)
						((gEgo inRect: 204 129 233 148)
							(if (not gNight)
								(HandsOff)
								(gEgo loop: 0)
								(doorSound play: door)
								(door ignoreActors: setCycle: End)
							else
								(Print 7 26) ; "You can't. It's locked and you don't have the key."
							)
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance water of Script
	(properties)

	(method (doit)
		(= local1 (gEgo onControl: 1))
		(if (and (!= local0 local1) (!= global107 9))
			(= local0 local1)
			(gEgo setCycle: Walk)
			(switch local1
				(1
					(= global105 0)
					(gEgo view: 2)
				)
				(2048
					(gEgo observeControl: 16384)
					(= global105 1)
					(gEgo view: 5)
				)
				(512
					(= global105 2)
					(gEgo view: 6)
				)
				(8
					(gEgo view: 7)
					(= global105 3)
				)
				(2
					(gEgo view: 8)
					(= global105 4)
					(gEgo setCycle: Fwd)
				)
			)
		)
	)
)

(instance fallSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(gEgo
					viewer: 0
					illegalBits: 0
					yStep: 9
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 35) self
					view: 17
					cel: 255
					setCycle: End
				)
			)
			(1
				(= global107 0)
				(gEgo yStep: 2 setPri: -1)
				(gEgo
					view: 19
					loop: (& (gEgo loop:) $0001)
					cel: 255
					setCycle: End self
				)
			)
			(2
				(HandsOn)
				(gEgo viewer: water illegalBits: $8000 observeControl: 1024)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance fallNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 11
					posn: (gEgo x:) (- (gEgo y:) 5)
					yStep: 8
					view: 17
					cel: 255
					setCycle: End
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(1
				(gEgo
					yStep: 2
					setPri: -1
					loop: 3
					view: 7
					illegalBits: $8000
					observeControl: 1024
					viewer: water
				)
				(= global107 0)
				(gCurRoom setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance fallRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					viewer: 0
					view: 17
					illegalBits: 0
					setPri: 14
					xStep: 10
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 173 186 self
				)
				(fallSound play:)
			)
			(1
				(gEgo xStep: 3 yStep: 2 view: 18 loop: 0 setCycle: Fwd)
				(= global107 0)
				(= seconds 5)
				(dizzySound play:)
			)
			(2
				(gEgo
					illegalBits: $8000
					observeControl: 1024
					setCycle: Walk
					loop: 1
					view: 2
					cycleSpeed: 0
					viewer: water
				)
				(gCurRoom setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance fishWalkHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local4 setMotion: MoveTo 207 140 self)
			)
			(1
				(local4 setPri: 10)
				(door setCycle: End self)
				(doorSound play:)
			)
			(2
				(local4 setMotion: MoveTo 226 134 self)
			)
			(3
				(local4 setMotion: MoveTo 255 134 self)
			)
			(4
				(door ignoreActors: 0 setCycle: Beg self)
				(= global116 3)
				(local4 dispose:)
			)
			(5
				(door stopUpd:)
			)
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local11 0)) (< local11 (waves size:)) ((++ local11))
					((View new:)
						view: ((waves at: local11) view:)
						loop: ((waves at: local11) loop:)
						cel: 255
						setPri: 0
						ignoreActors:
						x: ((waves at: local11) x:)
						y: ((waves at: local11) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local11 0)
				(self changeState: 1)
			)
			(1
				((waves at: local11) cel: 255 show: setCycle: End self)
			)
			(2
				((waves at: local11) hide:)
				(if (< local11 (- (waves size:) 1))
					(++ local11)
				else
					(= local11 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

