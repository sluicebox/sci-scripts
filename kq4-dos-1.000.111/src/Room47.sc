;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	Room47 0
)

(synonyms
	(room room castle)
)

(local
	local0
	local1
	local2
	local3
)

(instance theMusic of Sound
	(properties)
)

(instance Room47 of Rm
	(properties
		picture 47
		style 16
	)

	(method (init)
		(Load rsVIEW 632)
		(Load rsVIEW 111)
		(Load rsVIEW 113)
		(super init:)
		(if (or (== gPrevRoomNum 37) (== gPrevRoomNum 0))
			(gEgo posn: 156 177 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 46)
			(gEgo posn: 72 142 view: 4 xStep: 4 yStep: 1 init:)
		)
		((View new:) view: 632 loop: 0 cel: 3 posn: 38 106 setPri: 14 addToPic:)
		((View new:)
			view: 632
			loop: 0
			cel: 4
			posn: 281 107
			setPri: 14
			addToPic:
		)
		((= local0 (Act new:))
			view: 632
			loop: 2
			cel: 2
			illegalBits: 0
			setPri: 14
			posn: 41 98
			setCycle: Fwd
			init:
		)
		((= local1 (Act new:))
			view: 632
			loop: 2
			cel: 2
			illegalBits: 0
			setPri: 14
			setCycle: Fwd
			posn: 278 99
			init:
		)
		((= local2 (Act new:))
			view: 111
			posn: 250 80
			illegalBits: 8192
			setPri: 14
			xStep: 1
			yStep: 3
			setMotion: Wander 5
			setCycle: Fwd
			init:
		)
		((= local3 (Act new:))
			view: 113
			posn: 65 75
			illegalBits: 8192
			setPri: 14
			xStep: 1
			yStep: 3
			setMotion: Wander 5
			setCycle: Fwd
			init:
		)
		(theMusic number: 33 loop: 1 play:)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 37)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gCurRoom newRoom: 46)
		)
	)

	(method (dispose)
		(theMusic dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((or (Said 'look[<around][/!*]') (Said 'look[<around]/room'))
					(Print 47 0) ; "This is the entry hall of the enchanted ivory palace. Two of the doors are closed, and presumably, off-limits to uninvited visitors. The left doorway, however, is open."
				)
				((Said 'look>')
					(cond
						(
							(or
								(Said '<around')
								(Said '[<around]/room,room,hall,entry')
							)
							(Print 47 0) ; "This is the entry hall of the enchanted ivory palace. Two of the doors are closed, and presumably, off-limits to uninvited visitors. The left doorway, however, is open."
						)
						((Said '/door')
							(Print 47 1) ; "Two of the doors are closed, locked, and off-limits to uninvited visitors; but, the left doorway is open. The main palace door is behind you."
						)
						((Said '/flora,blossom')
							(Print 47 2) ; "An unusual vine clings to the back wall of the palace entry hall."
						)
						((Said '/wall')
							(Print 47 3) ; "There is nothing of importance on the walls."
						)
						((Said '[<down]/dirt')
							(Print 47 4) ; "There is nothing interesting on the floor."
						)
						((Said '/fairies[<little]')
							(Print 47 5) ; "Genesta's constant companions are small fairies with fluttering wings and brightly-colored gowns. They utter not a word."
						)
					)
				)
				((Said 'open/door')
					(if
						(or
							(gEgo inRect: 146 127 176 131)
							(gEgo inRect: 238 141 260 153)
						)
						(Print 47 6) ; "You can't. The door is locked."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'unlatch/door')
					(if
						(or
							(gEgo inRect: 146 127 176 131)
							(gEgo inRect: 238 141 260 153)
						)
						(if (or (gEgo has: 32) (gEgo has: 20)) ; Gold_Key, Skeleton_Key
							(Print 47 7) ; "You don't have the right key."
						else
							(Print 47 8) ; "You can't. It's locked and you don't have the key."
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'bang/door')
					(if
						(or
							(gEgo inRect: 146 127 176 131)
							(gEgo inRect: 238 141 260 153)
						)
						(Print 47 9) ; "There's no answer."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'break/door')
					(if
						(or
							(gEgo inRect: 146 127 176 131)
							(gEgo inRect: 238 141 260 153)
						)
						(Print 47 10) ; "You could never do that."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'use/key')
					(if
						(or
							(gEgo inRect: 146 127 176 131)
							(gEgo inRect: 238 141 260 153)
						)
						(if (or (gEgo has: 20) (gEgo has: 32)) ; Skeleton_Key, Gold_Key
							(Print 47 11) ; "You don't have the key to unlock this door."
						else
							(Print 47 12) ; "You don't have any keys!"
						)
					else
						(Print 47 13) ; "There is nothing within reach to use it on."
					)
				)
				((or (Said 'talk/fairies[<little]') (Said 'talk[/!*]'))
					(Print 47 14) ; "You speak to the little fairies, but they do not respond. Perhaps, they cannot talk."
				)
				((Said 'kill/fairies[<little]')
					(Print 47 15) ; "You are NOT a murderous girl, Rosella!"
				)
				((Said 'get/fairies[<little]')
					(Print 47 16) ; "It's impossible to obtain a fairy."
				)
				((Said 'capture/fairies[<little]')
					(Print 47 16) ; "It's impossible to obtain a fairy."
				)
				((or (Said 'kiss/fairies[<little]') (Said 'kiss[/!*]'))
					(Print 47 17) ; "The little fairies do not need kissing."
				)
				((Said 'help/fairies[<little]')
					(Print 47 18) ; "The little fairies don't need your help; Genesta does."
				)
				((Said 'give/*/fairies')
					(Print 47 19) ; "The small fairies don't need anything."
				)
			)
		)
	)
)

