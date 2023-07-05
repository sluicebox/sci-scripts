;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	Room37 0
)

(local
	local0
	local1
)

(instance fairieTheme of Sound
	(properties)
)

(instance door of Prop
	(properties)

	(method (cue)
		(self ignoreActors:)
		(HandsOn)
		(gCurRoom newRoom: 47)
	)
)

(instance Room37 of Rm
	(properties
		picture 37
	)

	(method (init)
		(= north 47)
		(= south 40)
		(= east 38)
		(= west 36)
		(= horizon 93)
		(= gIndoors 0)
		(if gNight
			(= picture 137)
		)
		(gEgo edgeHit: 0)
		(super init:)
		(self setRegions: 505) ; gfReg
		(Load rsVIEW 613)
		(Load rsVIEW 2)
		(Load rsVIEW 114)
		(door view: 613 loop: 0 cel: 0 posn: 158 94 setPri: 5 init: stopUpd:)
		(if (<= (gEgo y:) horizon)
			(gEgo y: (+ horizon 2))
		)
		(switch gPrevRoomNum
			(47
				(gEgo posn: 159 (+ horizon 3))
			)
			(36 ; Room_36
				(gEgo posn: 1 (gEgo y:))
			)
			(38
				(gEgo posn: 317 (gEgo y:))
			)
			(40
				(gEgo posn: 157 188)
			)
		)
		(gEgo view: 2 xStep: 2 yStep: 1 init:)
		(= local0 (Act new:))
		(local0
			ignoreHorizon:
			posn: 186 36
			view: 110
			setMotion: Wander 10
			illegalBits: -32768
			setCycle: Fwd
			setPri: 15
			xStep: 1
			yStep: 1
			init:
		)
		(= local1 (Act new:))
		(local1
			ignoreHorizon:
			posn: 107 37
			view: 114
			setMotion: Wander 10
			illegalBits: -32768
			setCycle: Fwd
			setPri: 15
			xStep: 1
			yStep: 1
			init:
		)
		(Print 37 0) ; "Genesta's tiny fairies guard the palace door."
		(fairieTheme number: 33 priority: -1 play:)
	)

	(method (newRoom newRoomNumber)
		(User canControl: 1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/bush')
							(Print 37 1) ; "A lovely hedge surrounds this island garden."
						)
						((Said '/dirt')
							(Print 37 2) ; "You see nothing but grass on the ground."
						)
						((Said '/grass')
							(Print 37 3) ; "The grass looks well-tended and manicured."
						)
						((Said '/flora')
							(Print 37 4) ; "The foliage grows luxuriantly here."
						)
						((Said '/blossom')
							(Print 37 5) ; "You see lovely beds of well-tended flowers."
						)
						((Said '/forest')
							(Print 37 6) ; "You see many unusual and lovely trees on this island."
						)
						((Said '/garden')
							(Print 37 7) ; "The beautiful garden gives you a sense of peaceful serenity."
						)
						((Said '/castle')
							(Print 37 8) ; "The lovely ivory palace rises majestically before you."
						)
						((Said '/beach')
							(Print 37 9) ; "You can see the beach in the distance."
						)
						((Said '/ocean,water')
							(Print 37 10) ; "You can see the ocean in the distance."
						)
						((Said '/door')
							(Print 37 11) ; "It's an elegant door."
						)
						((Said '/fairies')
							(Print 37 12) ; "Two small fairies hover protectively above the palace door."
						)
						((Said '/bird')
							(Print 37 13) ; "There are many exotic birds on this island."
						)
						((Said '/path')
							(Print 37 14) ; "A nice flagstone path leads to the palace door."
						)
						((Said '[<around][/room,island]')
							(Print 37 15) ; "Before you, the palace door beckons, flanked on both sides by lilac shrubs."
						)
					)
				)
				((Said 'get/blossom')
					(Print 37 16) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'open/door')
					(if (gEgo inRect: 140 93 180 103)
						(gEgo setMotion: 0)
						(HandsOff)
						((Sound new:)
							number: 300
							priority: 999
							loop: 1
							play: door
						)
						(door setCycle: End)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((or (Said 'kiss[/!*]') (Said 'kiss/fairies'))
					(Print 37 17) ; "You can't get close enough."
				)
				((or (Said 'talk/fairies') (Said 'talk[/!*]'))
					(Print 37 18) ; "You speak to the little fairies, but they do not respond. Perhaps, they cannot talk."
				)
				((Said 'bang')
					(if (gEgo inRect: 141 94 175 103)
						(Print 37 19) ; "The tiny fairies watch you closely."
					else
						(Print 37 20) ; "You're not close enough."
					)
				)
				((Said 'get,capture/fairies')
					(Print 37 21) ; "It is impossible to obtain a fairy."
				)
				((and (Said 'give>') (= temp0 (gInventory saidMe:)))
					(if (gEgo has: (gInventory indexOf: temp0))
						(Print 37 22) ; "The small fairies don't need anything."
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

