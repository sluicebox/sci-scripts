;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room53 0
)

(synonyms
	(room bedroom cottage)
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	[local24 2]
	local26
	local27
)

(instance Room53 of Rm
	(properties
		picture 53
		style 16
	)

	(method (init)
		(Load rsVIEW 676)
		(Load rsVIEW 290)
		(self setRegions: 601) ; regDwarfHouse
		(= global189 1)
		(super init:)
		((View new:) view: 676 loop: 3 cel: 0 posn: 230 77 setPri: 4 addToPic:)
		((View new:) view: 676 loop: 3 cel: 1 posn: 42 88 setPri: 10 addToPic:)
		(if (or (== gPrevRoomNum 54) (== gPrevRoomNum 0))
			(gEgo
				posn: 72 132
				view: 4
				setStep: 4 1
				illegalBits: $8000
				init:
			)
		)
		(if global115
			(self setScript: cleanBedroom)
		)
		(if (not global102)
			(Load rsVIEW 675)
			(Load rsVIEW 676)
			(Load rsVIEW 63)
			(Load rsVIEW 678)
			(Load rsSOUND 62)
			((= local26 (Act new:))
				view: 290
				illegalBits: 0
				loop: 0
				setCycle: Walk
				posn: 72 1132
				illegalBits: 0
				ignoreActors: 1
				setCycle: Walk
				setScript: chaseEgo
				init:
			)
			((= local7 (View new:))
				view: 676
				loop: 0
				cel: 0
				posn: 102 89
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local8 (View new:))
				view: 676
				loop: 0
				cel: 1
				posn: 261 125
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local9 (View new:))
				view: 676
				loop: 0
				cel: 2
				posn: 246 136
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local10 (View new:))
				view: 676
				loop: 0
				cel: 3
				posn: 101 112
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local11 (View new:))
				view: 676
				loop: 0
				cel: 4
				posn: 198 107
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local12 (View new:))
				view: 676
				loop: 0
				cel: 5
				posn: 97 150
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local13 (View new:))
				view: 676
				loop: 0
				cel: 6
				posn: 174 147
				ignoreActors: 1
				setPri: 13
				stopUpd:
				init:
			)
			((= local14 (View new:))
				view: 676
				loop: 1
				cel: 0
				posn: 275 150
				ignoreActors: 1
				setPri: 11
				stopUpd:
				init:
			)
			((= local15 (View new:))
				view: 676
				loop: 1
				cel: 1
				posn: 255 147
				ignoreActors: 1
				setPri: 11
				stopUpd:
				init:
			)
			((= local16 (View new:))
				view: 676
				loop: 1
				cel: 2
				posn: 201 147
				ignoreActors: 1
				setPri: 13
				stopUpd:
				init:
			)
			((= local17 (View new:))
				view: 676
				loop: 1
				cel: 3
				posn: 195 84
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local18 (View new:))
				view: 676
				loop: 2
				cel: 0
				posn: 182 126
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local19 (View new:))
				view: 676
				loop: 2
				cel: 1
				posn: 17 147
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local20 (View new:))
				view: 676
				loop: 2
				cel: 2
				posn: 24 137
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local21 (View new:))
				view: 676
				loop: 2
				cel: 3
				posn: 292 140
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local22 (View new:))
				view: 676
				loop: 2
				cel: 4
				posn: 264 134
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local23 (View new:))
				view: 676
				loop: 2
				cel: 5
				posn: 270 136
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local0 (View new:))
				view: 675
				loop: 0
				cel: 0
				posn: 128 93
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local1 (View new:))
				view: 675
				loop: 0
				cel: 1
				posn: 178 92
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local2 (View new:))
				view: 675
				loop: 0
				cel: 2
				posn: 130 118
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local3 (View new:))
				view: 675
				loop: 0
				cel: 3
				posn: 177 121
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local4 (View new:))
				view: 675
				loop: 0
				cel: 4
				posn: 237 121
				ignoreActors: 1
				stopUpd:
				init:
			)
			((= local5 (View new:))
				view: 675
				loop: 0
				cel: 5
				posn: 132 157
				ignoreActors: 1
				setPri: 13
				stopUpd:
				init:
			)
			((= local6 (View new:))
				view: 675
				loop: 0
				cel: 6
				posn: 173 157
				ignoreActors: 1
				setPri: 13
				stopUpd:
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 54)
		)
	)

	(method (dispose)
		(if (== keep 0)
			(= global189 0)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'clean/room') (Said 'clean[/!*]'))
				(if (!= global102 1)
					(self setScript: cleanBedroom)
				else
					(Print 53 0) ; "The house is nice and clean now."
				)
			)
			((Said 'look>')
				(cond
					((Said '/bed')
						(Print 53 1) ; "There are seven little beds."
					)
					((Said '/stair')
						(Print 53 2) ; "The narrow stairs lead downward."
					)
					((Said '<under/bed')
						(Print 53 3) ; "There is nothing under the beds."
					)
					((Said '/window')
						(if (gEgo inRect: 211 125 271 146)
							(Print 53 4) ; "You see the forest out the window."
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said '<in/chest,dresser,drawer')
						(Print 53 5) ; "It's full of dirty, messy, dwarf clothes."
					)
					((Said '/chest,dresser')
						(Print 53 6) ; "The dwarfs share one chest of drawers."
					)
					((Said '/mirror')
						(if (gEgo inRect: 217 142 295 161)
							(Print 53 7) ; "You look in the mirror and see the reflection of a poor, but beautiful, peasant girl."
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said '/shelf')
						(Print 53 8) ; "Quit being a snoop, Rosella!"
					)
					((Said '/wall')
						(Print 53 9) ; "There is nothing of importance on the walls."
					)
					((or (Said '/dirt') (Said '<down'))
						(Print 53 10) ; "There is nothing interesting on the floor."
					)
					((Said '/carpet,carpet')
						(Print 53 11) ; "A nice braided rug lies on the floor."
					)
					((Said 'look[<around][/room]')
						(Print
							(Format ; "You have entered the small upstairs bedroom of the Seven Dwarfs. %s"
								@global300
								53
								12
								(if (not global102)
									{My goodness, these dwarfs are sloppy!}
								else
									{ }
								)
							)
						)
					)
				)
			)
			((or (Said 'make/bed') (Said 'dust,sweep[/room,dirt,furniture]'))
				(if global102
					(Print 53 0) ; "The house is nice and clean now."
				else
					(Print 53 13) ; "The house needs more than that!"
				)
			)
			((Said 'close,close/drawer,dresser,chest')
				(Print 53 14) ; "You can't. It's too full of dirty, messy, dwarf clothes."
			)
			((Said 'open/chest,dresser,drawer')
				(Print 53 15) ; "No. It's private."
			)
			((or (Said 'get<in,on/bed') (Said 'sleep,lay[<down,on,in]'))
				(Print 53 16) ; "You have better things to do."
			)
		)
	)
)

(instance cleanBedroom of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(gEgo
			illegalBits: 0
			ignoreActors: 1
			setCycle: Walk
			setLoop: -1
			init:
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(super changeState: newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global205 1)
				(if (not global115)
					(Notify 601 1)
					(= global115 1)
				)
				(gEgo setCycle: Walk setMotion: MoveTo 137 131 self)
			)
			(1
				(gEgo setMotion: MoveTo 130 145 self)
			)
			(2
				(gEgo view: 63 setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(local5 dispose:)
				(local12 dispose:)
				(gEgo view: 4 setMotion: MoveTo 185 145 self)
			)
			(4
				(gEgo view: 63 loop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(5
				(local6 dispose:)
				(local13 dispose:)
				(local16 dispose:)
				(gEgo view: 4 setMotion: MoveTo 231 145 self)
			)
			(6
				(self cue:)
			)
			(7
				(gEgo view: 4 setMotion: MoveTo 237 157 self)
			)
			(8
				(gEgo view: 63 loop: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(9
				(local23 dispose:)
				(local22 dispose:)
				(local21 dispose:)
				(local15 dispose:)
				(local14 dispose:)
				(gEgo view: 4 setMotion: MoveTo 232 130 self)
			)
			(10
				(gEgo view: 63 loop: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(11
				(local4 dispose:)
				(local8 dispose:)
				(local9 dispose:)
				(gEgo view: 4 setMotion: MoveTo 187 126 self)
			)
			(12
				(gEgo view: 63 loop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(local1 dispose:)
				(local3 dispose:)
				(local11 dispose:)
				(local17 dispose:)
				(local18 dispose:)
				(gEgo view: 4 setMotion: MoveTo 115 126 self)
			)
			(14
				(gEgo view: 63 loop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(15
				(local0 dispose:)
				(local2 dispose:)
				(local7 dispose:)
				(local10 dispose:)
				(gEgo view: 4 setMotion: MoveTo 41 151 self)
			)
			(16
				(gEgo view: 63 loop: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(17
				(local19 dispose:)
				(local20 dispose:)
				(gEgo view: 4 setLoop: -1 setMotion: MoveTo 91 133 self)
			)
			(18
				(= global204 0)
				(gEgo setMotion: MoveTo 71 133 self)
			)
			(19
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance chaseEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(if
					(or
						global115
						gDwarfEscortOut
						global204
						global102
						(not (gEgo inRect: 95 127 241 145))
					)
					(-- state)
					(= seconds 5)
				else
					(local26
						setAvoider: Avoid
						posn: 55 131
						setMotion: MoveTo 78 131 self
					)
					(HandsOff)
					(= global204 0)
					(= global205 1)
					(= gDwarfEscortOut 1)
				)
			)
			(2
				(Print 53 17) ; "Oh, oh! You've been caught trespassing! You are unceremoniously ordered out by an angry dwarf."
				(gEgo
					illegalBits: 0
					setAvoider: Avoid
					setMotion: MoveTo 75 135 self
				)
			)
			(3
				(local26 setMotion: Follow gEgo 20)
				(gEgo setMotion: MoveTo 10 135 self)
			)
		)
	)
)

