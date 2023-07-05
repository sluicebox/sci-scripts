;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room86 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance Room86 of Rm
	(properties
		picture 86
		style 16
	)

	(method (init)
		(Load rsVIEW 81)
		(Load rsVIEW 82)
		(Load rsVIEW 147)
		(Load rsVIEW 607)
		(Load rsVIEW 141)
		(Load rsVIEW 633)
		(super init:)
		(self setRegions: 604) ; regBFCastle
		((= local5 (Prop new:)) view: 607 posn: 202 118 init: hide:)
		((= local2 (Prop new:))
			posn: 281 65
			view: 633
			cel: 2
			init:
			setCycle: Fwd
		)
		((= local3 (Prop new:))
			posn: 289 76
			view: 633
			cel: 0
			init:
			setCycle: Fwd
		)
		((= local4 (Prop new:))
			posn: 296 65
			view: 633
			cel: 1
			init:
			setCycle: Fwd
		)
		(if (or (== gPrevRoomNum 87) (== gPrevRoomNum 0))
			(gEgo posn: 303 142 view: 4 xStep: 4 yStep: 1 init:)
			(local5 cel: 0 init: stopUpd:)
			(if global175
				((= local0 (Act new:))
					view: 141
					posn: (+ (gEgo x:) 40) (gEgo y:)
					setCycle: Walk
					illegalBits: 0
					init:
					setScript: henchChase
				)
				((= local6 (Sound new:)) number: 41 loop: 0 init:)
			)
		)
		(if (== gPrevRoomNum 83)
			(if (== gAct 0)
				(User canControl: 0 canInput: 0)
				(gEgo
					view: 81
					loop: 2
					posn: 190 121
					init:
					setCycle: Walk
					setScript: toThrone
				)
			else
				(gEgo posn: 190 121 view: 4 setStep: 4 1 init:)
			)
			(local5 cel: 0 init: stopUpd:)
		)
		(if (== gPrevRoomNum 92)
			(gEgo
				view: 81
				loop: 1
				posn: 293 142
				setStep: 4 1
				init:
				setCycle: Walk
			)
			(User canControl: 0 canInput: 0)
			(self setScript: intoDungeon)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl:) $0040) (!= gAct 0))
			(gCurRoom newRoom: 87)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look/room,castle,hall')
						)
						(Print
							(Format ; "This is the west end of a dim hallway. There is %s door here."
								@global300
								86
								0
								(if (== (local5 cel:) 0)
									{a closed}
								else
									{an open}
								)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/door')
								(Print 86 1) ; "It appears to be a cell door."
							)
							((Said '/table')
								(Print 86 2) ; "There is a candelabra on the table shedding dim candlelight."
							)
							((Said '/candelabra,candle')
								(Print 86 3) ; "Candle light flickers from the candelabra."
							)
							((Said '/chair')
								(Print 86 4) ; "This is quite a fancy chair."
							)
							((Said '/wall')
								(Print 86 5) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 86 6) ; "There is nothing of importance on the floor."
							)
						)
					)
					((Said 'bang/door')
						(if (< (gEgo distanceTo: local5) 15)
							(Print 86 7) ; "There's nobody there..."
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'open/door')
						(cond
							((> (gEgo distanceTo: local5) 15)
								(Print 800 1) ; "You're not close enough."
							)
							((!= (local5 cel:) 0)
								(Print 86 8) ; "It is already open."
							)
							(else
								(self setScript: openDoor)
							)
						)
					)
					((Said 'close/door')
						(Print 86 9) ; "It already is closed."
					)
					((Said 'unlatch/door')
						(if (< (gEgo distanceTo: local5) 15)
							(Print 86 10) ; "Why don't you just open it?"
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'sit/chair')
						(Print 86 11) ; "You don't have time for that!"
					)
					((Said 'get/candelabra')
						(Print 86 12) ; "It's not for you."
					)
				)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(local5 setCycle: End self)
				(local5 ignoreActors: 1)
				((Sound new:) number: 300 loop: 1 play:)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance intoDungeon of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 187 122 self)
			)
			(1
				(gEgo view: 82 loop: 0)
				(self cue:)
			)
			(2
				((= local0 (Act new:))
					view: 147
					loop: 3
					posn: (- (gEgo x:) 15) (gEgo y:)
					init:
					moveSpeed: 1
					setCycle: End
				)
				((= local1 (Act new:))
					view: 147
					loop: 4
					posn: (+ (gEgo x:) 15) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					init:
					moveSpeed: 1
					setCycle: End
				)
				(gEgo loop: 1 setCycle: End self)
			)
			(3
				(User canControl: 1 canInput: 1)
				(gEgo setLoop: -1)
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance toThrone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 329 130 self)
			)
			(1
				(= global205 1)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance henchChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local6 number: 41 loop: 10 play:)
				(client setMotion: Chase gEgo 15 self)
			)
			(1
				(User canControl: 0 canInput: 0)
				(gEgo moveSpeed: 0 setMotion: 0)
				(local6 number: 42 loop: 1 play:)
				(= seconds 3)
			)
			(2
				(= global205 1)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

