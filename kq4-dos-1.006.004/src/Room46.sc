;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room46 0
)

(synonyms
	(room room castle)
)

(local
	local0
	local1
)

(instance theMusic of Sound
	(properties
		number 33
	)
)

(instance Room46 of Rm
	(properties
		picture 46
		style 16
	)

	(method (init)
		(Load rsVIEW 110)
		(Load rsVIEW 114)
		(super init:)
		(= global105 0)
		(if (or (== gPrevRoomNum 47) (== gPrevRoomNum 0))
			(gEgo
				view: 4
				baseSetter: (ScriptID 0 1) ; smallBase
				posn: 250 164
				setStep: 4 2
				setPri: -1
				init:
			)
			(HandsOff)
		)
		(if (== gPrevRoomNum 45)
			(gEgo
				view: 4
				baseSetter: (ScriptID 0 1) ; smallBase
				posn: 184 23
				setStep: 4 2
				setPri: 6
				illegalBits: 16384
				init:
			)
		)
		((= local0 (Act new:))
			view: 111
			posn: 231 65
			illegalBits: 8192
			setPri: 14
			xStep: 1
			yStep: 3
			setMotion: Wander 5
			setCycle: Fwd
			init:
		)
		((= local1 (Act new:))
			view: 113
			posn: 132 144
			illegalBits: 8192
			setPri: 14
			xStep: 1
			yStep: 3
			setMotion: Wander 5
			setCycle: Fwd
			init:
		)
		(theMusic play:)
		(gEgo observeBlocks: stairBlock1 stairBlock2 stairBlock3 stairBlock4)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo setPri: -1 baseSetter: 0)
			(gCurRoom newRoom: 47)
		)
		(if (& (gEgo onControl: 0) $0020)
			(HandsOn)
			(gEgo setPri: -1 illegalBits: -32768 baseSetter: 0)
			(gCurRoom newRoom: 45)
		)
		(if (& (gEgo onControl: 0) $0200)
			(gEgo setPri: 4)
		)
		(if (& (gEgo onControl: 0) $0010)
			(if (and (== global105 18) (== (gEgo script:) 0))
				(gEgo illegalBits: -32768 setPri: 4)
			else
				(gEgo setPri: 6)
			)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0008)
				(not (& (gEgo signal:) $0010))
			)
			(gEgo setPri: 4)
		)
		(if (& (gEgo onControl: 0) $1000)
			(gEgo setPri: -1)
		)
		(if
			(and
				(!= global105 18)
				(or
					(& (gEgo onControl: 0) $0800)
					(& (gEgo onControl: 1) $0400)
				)
			)
			(HandsOff)
			(= global105 18)
			(gEgo setScript: moveOnTheStairs)
			(if (& (gEgo onControl: 0) $0800)
				(moveOnTheStairs changeState: 10)
			else
				(moveOnTheStairs changeState: 1)
			)
		)
	)

	(method (dispose)
		(theMusic dispose:)
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
							((Said '<up[/!*]')
								(Print 46 0) ; "Where do the stairs lead?"
							)
							((Said '<down[/!*]')
								(Print 46 1) ; "The stairs lead down to the entry hall."
							)
							((Said '[<up,down]/stair[<tower]')
								(Print 46 2) ; "From here, the tower stairs both go upward, and downward."
							)
							((Said '[<out,through]/window')
								(if (gEgo inRect: 33 81 67 112)
									(Print 46 3) ; "You see the ocean out the window."
								else
									(Print 46 4) ; "You're not close enough to the window."
								)
							)
							((Said '/wall')
								(Print 46 5) ; "There is nothing of importance on the walls."
							)
							((Said '[<down]/dirt')
								(Print 46 6) ; "There is nothing interesting on the floor."
							)
							((Said '/painting,tapestries')
								(Print 46 7) ; "A beautifully embroidered tapestry hangs on the gleaming wall."
							)
							((Said '/flora,blossom')
								(Print 46 8) ; "Genesta must love beautiful plants and flowers."
							)
							((Said '/fairies[<little]')
								(Print 46 9) ; "Genesta's constant companions are small fairies with fluttering wings and brightly-colored gowns. They utter not a word."
							)
							((Said '[<around][/room,tower]')
								(Print 46 10) ; "You are on a tower stairway of the island's ivory palace."
							)
						)
					)
					((or (Said 'talk/fairies[<little]') (Said 'talk[/!*]'))
						(Print 46 11) ; "You speak to the little fairies, but they do not respond. Perhaps, they cannot talk."
					)
					((Said 'kill/fairies[<little]')
						(Print 46 12) ; "You are NOT a murderous girl, Rosella!"
					)
					((Said 'get/fairies[<little]')
						(Print 46 13) ; "It's impossible to obtain a fairy."
					)
					((Said 'capture/fairies[<little]')
						(Print 46 13) ; "It's impossible to obtain a fairy."
					)
					((or (Said 'kiss/fairies[<little]') (Said 'kiss[/!*]'))
						(Print 46 14) ; "The little fairies do not need kissing."
					)
					((Said 'help/fairies[<little]')
						(Print 46 15) ; "The little fairies don't need your help; Genesta does."
					)
				)
			)
		)
	)
)

(instance stairBlock1 of Blk
	(properties
		top 83
		left 89
		bottom 85
		right 91
	)
)

(instance stairBlock2 of Blk
	(properties
		top 83
		left 115
		bottom 85
		right 117
	)
)

(instance stairBlock3 of Blk
	(properties
		top 93
		left 103
		bottom 95
		right 105
	)
)

(instance stairBlock4 of Blk
	(properties
		top 93
		left 75
		bottom 95
		right 77
	)
)

(instance moveOnTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					ignoreBlocks:
						stairBlock1
						stairBlock2
						stairBlock3
						stairBlock4
				)
				(= global205 1)
				(= global204 0)
				(if (> (gEgo y:) 150)
					(gEgo illegalBits: 0)
					(gEgo setMotion: MoveTo 199 133 self)
				else
					(gEgo illegalBits: 0)
					(gEgo setMotion: MoveTo 261 172 self)
				)
			)
			(2
				(if (& (gEgo onControl:) $0040)
					(gEgo setPri: -1 illegalBits: -32768 baseSetter: 0)
					(HandsOn)
					(gCurRoom newRoom: 47)
				else
					(gEgo
						observeBlocks:
							stairBlock1
							stairBlock2
							stairBlock3
							stairBlock4
					)
					(gEgo illegalBits: -32768 setScript: 0)
					(HandsOn)
					(= global105 0)
				)
			)
			(10
				(= global205 1)
				(= global204 0)
				(gEgo
					ignoreBlocks:
						stairBlock1
						stairBlock2
						stairBlock3
						stairBlock4
				)
				(if (< (gEgo y:) 50)
					(gEgo illegalBits: 0)
					(gEgo setMotion: MoveTo 69 105 self)
				else
					(gEgo illegalBits: 0)
					(gEgo setMotion: MoveTo 205 7 self)
				)
			)
			(11
				(gEgo
					observeBlocks:
						stairBlock1
						stairBlock2
						stairBlock3
						stairBlock4
				)
				(if (& (gEgo onControl:) $0020)
					(gEgo setPri: -1 illegalBits: -32768 baseSetter: 0)
					(HandsOn)
					(gCurRoom newRoom: 45)
				else
					(HandsOn)
					(gEgo illegalBits: -32768 setScript: 0)
					(= global105 0)
				)
			)
		)
	)
)

