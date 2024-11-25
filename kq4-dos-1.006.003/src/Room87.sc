;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room87 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance theMusic of Sound
	(properties)
)

(instance doorSound of Sound
	(properties
		number 300
	)
)

(instance Room87 of Rm
	(properties
		picture 87
		style 16
	)

	(method (init)
		(Load rsVIEW 145)
		(Load rsVIEW 141)
		(Load rsVIEW 633)
		(Load rsVIEW 608)
		(Load rsVIEW 147)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		(Notify 604 0)
		(theMusic number: 41 loop: 0 init:)
		((= local6 (Prop new:)) view: 608 posn: 140 117 cel: 0 init: stopUpd:)
		((= local3 (Prop new:))
			posn: 24 64
			view: 633
			cel: 2
			init:
			setCycle: Fwd
		)
		((= local4 (Prop new:))
			posn: 32 74
			view: 633
			cel: 0
			init:
			setCycle: Fwd
		)
		((= local5 (Prop new:))
			posn: 42 64
			view: 633
			cel: 1
			init:
			setCycle: Fwd
		)
		(if gLolotteAlive
			((= local0 (Act new:))
				view: 145
				loop: 4
				posn: 200 122
				init:
				setScript: henchChase
			)
		else
			((= local0 (Act new:)) view: 147 loop: 1 cel: 0 posn: 272 153 init:)
			((= local1 (Act new:)) view: 147 loop: 2 cel: 0 posn: 250 157 init:)
			((= local2 (Act new:)) view: 147 loop: 2 cel: 0 posn: 212 158 init:)
			(gEgo observeControl: 1024)
			(local0 setScript: circleJerk)
		)
		(if (or (== gPrevRoomNum 88) (== gPrevRoomNum 0))
			(gEgo posn: 261 133 view: 4 xStep: 4 yStep: 2 init:)
		)
		(if (== gPrevRoomNum 86)
			(gEgo posn: 25 142 view: 4 xStep: 4 yStep: 2 init:)
		)
		(if (== gPrevRoomNum 84)
			(gEgo posn: 131 124 view: 4 xStep: 4 yStep: 2 init:)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 84)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 86)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gCurRoom newRoom: 84)
		)
		(if (& (gEgo onControl: 0) $0010)
			(gCurRoom newRoom: 88)
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
							(Said 'look[<around]/room,castle,hall')
						)
						(Print 87 0) ; "This is the east end of the hallway."
					)
					((Said 'look>')
						(cond
							((Said '/goon')
								(Print 87 1 #at -1 10) ; "Lolotte's goons are not appealing at all! Besides having an unnatural pallor to their skin, they are creepy little creatures who fly upon wings that resemble those of bats."
							)
							((Said '/door')
								(Print 87 2) ; "It's a plain wooden door."
							)
							((Said '/table')
								(Print 87 3) ; "There is a candelabra on the table, from which dim candle light sheds."
							)
							((Said '/candelabra,candle')
								(Print 87 4) ; "Candle light flickers from the candelabra."
							)
							((Said '/wall')
								(Print 87 5) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 87 6) ; "There is nothing of importance on the floor."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said '/man,goon')
						(if gLolotteAlive
							(Print 87 7) ; "Just get out of there!"
						else
							(Print 87 8) ; "Lolotte's goons won't bother you any more."
						)
					)
					((Said 'get/candelabra,candle')
						(Print 87 9 #at -1 10) ; "It's not for you."
					)
					((Said 'bang/door')
						(if (gEgo inRect: 111 118 140 123)
							(Print 87 10 #at -1 10) ; "There's nobody there..."
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'open/door')
						(cond
							((!= (local6 cel:) 0)
								(Print 87 11 #at -1 10) ; "It is already open."
							)
							((not (gEgo inRect: 111 118 140 123))
								(Print 800 1) ; "You're not close enough."
							)
							(else
								(local6 setCycle: End doDoor)
								(doorSound play:)
							)
						)
					)
					((Said 'close/door')
						(Print 87 12) ; "It already is."
					)
					((Said 'unlatch/door')
						(if (gEgo inRect: 111 118 140 123)
							(Print 87 13) ; "Why don't you just open it?"
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said '/goon,man>')
						(cond
							((Said 'talk')
								(Print 87 14 #at -1 10) ; "Lolotte's henchmen must not speak, as you only hear them utter guttural sounds."
							)
							((Said 'get,capture')
								(Print 87 15 #at -1 10) ; "Why would you want one?!"
							)
							((Said 'kiss')
								(Print 87 16 #at -1 10) ; "That's an AWFUL thought!"
							)
							((Said 'give')
								(Print 87 17 #at -1 10) ; "The henchmen are not interested in your offering."
							)
						)
					)
				)
			)
		)
	)
)

(instance doDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local6 stopUpd:)
				(gCurRoom newRoom: 84)
			)
		)
	)
)

(instance henchChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 loop: 2 setCycle: End self)
			)
			(1
				(local0 loop: 0 setCycle: End self)
			)
			(2
				(= global175 1)
				(theMusic number: 41 loop: 10 play:)
				(local0
					view: 141
					setAvoider: Avoid
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
			)
			(3
				(User canControl: 0 canInput: 0)
				(gEgo moveSpeed: 0 setMotion: 0)
				(theMusic number: 42 loop: 1 play:)
				(= seconds 4)
			)
			(4
				(= global205 1)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

(instance circleJerk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(1
				(local0 setCycle: End)
				(local1 setCycle: End)
				(local2 setCycle: End)
				((ScriptID 0 4) setReal: self 5) ; timer1
			)
			(2
				(local1 setCycle: Beg)
				(local0 setCycle: Beg)
				(local2 setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

