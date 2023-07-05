;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use BassSetter)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm81 0
)

(local
	readMessage
	spreading
	hasPissed
	aCoil
	aYellowName
	localBS
)

(instance rm81 of Rm
	(properties
		picture 81
		horizon 1
		south 80
	)

	(method (init)
		(Load rsVIEW 726)
		(Load rsVIEW 181)
		(Load rsVIEW 182)
		(Load rsVIEW 183)
		(Load rsVIEW 31)
		(Load rsVIEW 30)
		(super init:)
		((= aCoil (Prop new:))
			view: 726
			setLoop: 1
			posn: 151 122
			cycleSpeed: 10
			ignoreActors:
			init:
			hide:
		)
		((= aYellowName (Prop new:))
			view: 726
			setLoop: 0
			setCel: 0
			setPri: 11
			posn: 53 136
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
			hide:
		)
		(NormalEgo)
		(gEgo posn: 155 185 init:)
		(self setRegions: 700 setScript: rm81Script) ; rm700
	)
)

(instance rm81Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(== spreading 0)
					(== gCurrentStatus 0)
				)
				(= gCurrentStatus 1017)
				(self changeState: 1)
			)
			(
				(and
					(& (gEgo onControl: 1) $0004)
					(== spreading 0)
					(== gCurrentStatus 1017)
				)
				(= gCurrentStatus 1018)
				(self changeState: 2)
			)
			(
				(and
					(& (gEgo onControl: 1) $0010)
					(== spreading 0)
					(== gCurrentStatus 1017)
				)
				(= gCurrentStatus 1018)
				(self changeState: 7)
			)
			(
				(and
					(== hasPissed 0)
					(== 0 (gEgo loop:))
					(gEgo inRect: 34 161 37 165)
				)
				(= hasPissed 1)
				(self changeState: 20)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/glacier,glacier')
				(Print 81 0) ; "The ice is absolutely impenetrable. There's no way to crack, move, or break it."
			)
			(if (Said '/carpet,carpet')
				(Print 81 1) ; "The ramp-like path before you leads to the top of the volcano. It is very steep and very slippery!"
			)
			(if (Said '[/airport,island,hill,glacier,glacier]')
				(Print 81 2) ; "Ice, ice, everywhere. (And, not a drop to drink!)"
				(Print 81 3) ; "Isn't it amazing? With that hot, tropical sun overhead and the temperature somewhere in the nineties, this glacier remains frozen solid."
				(Print 81 4) ; "Somewhere, off in the far distance, you think you hear a low-pitched humming noise, like a large electric motor. How silly. There's no electricity on an uncivilized, isolated, tropical island like this!"
			)
		)
		(if
			(and
				(gEgo has: 21) ; Hair_Rejuvenator
				(Said 'drop,drain,apply,drop/bottle,rejuvenator')
			)
			(Print 81 5) ; "Ok. You dump the bottle of hair rejuvenator on the ice."
			(Print 81 6) ; "Nothing happens."
			(gEgo put: 21 -1) ; Hair_Rejuvenator
			(gGame changeScore: -5)
		)
		(if (Said 'run,climb')
			(Print 81 7) ; "Better watch out. This area is slippery!"
		)
		(if (Said 'throw,apply/ash')
			(cond
				((not (gEgo has: 30)) ; Ashes
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 127 130 202 154))
					(Print 81 8) ; "Move a little closer to the center of the ice-laden rampway leading up and out of this refrigerated hellhole!"
				)
				(else
					(gGame changeScore: 10)
					(Ok) ; "Ok."
					(= spreading 30)
					(self changeState: 8)
				)
			)
		)
		(if (Said 'throw,apply/beach')
			(cond
				((not (gEgo has: 31)) ; Sand
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 127 130 202 154))
					(Print 81 8) ; "Move a little closer to the center of the ice-laden rampway leading up and out of this refrigerated hellhole!"
				)
				(else
					(gGame changeScore: 10)
					(Ok) ; "Ok."
					(= spreading 31)
					(self changeState: 8)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Print 81 9 #at -1 20) ; "Hey! This ice is slippery!!"
				(gEgo
					view: 181
					setLoop: 0
					setCycle: Fwd
					setStep: 1 1
					baseSetter: (= localBS (BassSetter new:))
				)
			)
			(2
				(Print 81 10 #at -1 20) ; "Look out!"
				(HandsOff)
				(gEgo
					setStep: 1 5
					setLoop: 1
					cel: 0
					setCycle: End
					setMotion: MoveTo 160 132 self
				)
			)
			(3
				(gEgo view: 181 setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(Print 81 11 #draw) ; "Ow!"
				(= cycles 25)
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(NormalEgo 0)
				(self changeState: 7)
			)
			(7
				(gEgo baseSetter: 0)
				(NormalEgo)
				(if localBS
					(localBS dispose:)
				)
			)
			(8
				(= gCurrentStatus 1019)
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 156 133 self
				)
			)
			(9
				(aCoil posn: 153 118 cel: 0 setCycle: End self show:)
				(gEgo view: 182 setLoop: 0 setCycle: Fwd)
				(= cycles 10)
			)
			(10
				(if (== spreading 31)
					(gEgo put: 31 -1) ; Sand
					(Print 81 12 #icon 31 0 0 #at -1 20) ; "The broiling tropical sun strikes the sand you took from the beach and quickly melts the snow, revealing..."
				else
					(gEgo put: 30 -1) ; Ashes
					(Print 81 13 #icon 30 0 0 #at -1 20) ; "The broiling tropical sun strikes the black ashes you took from the village campfire and quickly melts the snow, revealing..."
				)
			)
			(11
				(Print 81 14 #at -1 15 #width 280 #draw) ; "...refrigeration coils! You immediately realize the meaning: Dr. Nonookee has created a glacier on the side of a volcano in the middle of the tropics to prevent the island natives from disturbing his evil doings!"
				(Print 81 15 #at -1 20) ; "What power!"
				(Print 81 16 #at -1 20) ; "What force!"
				(if (> gFilthLevel 10)
					(Print 81 17 #at -1 152) ; "(What an asshole!)"
				)
				(aCoil hide:)
				((View new:)
					view: 726
					loop: 1
					cel: 4
					posn: 153 118
					ignoreActors:
					addToPic:
				)
				(gEgo view: 183 cel: 0 posn: 156 117 setCycle: End self)
			)
			(12
				(aCoil posn: 153 102 cel: 0 setCycle: End self show:)
				(gEgo view: 182 setCycle: Fwd)
			)
			(13
				(aCoil hide:)
				((View new:)
					view: 726
					loop: 1
					cel: 4
					posn: 153 102
					ignoreActors:
					addToPic:
				)
				(gEgo view: 183 cel: 0 posn: 156 101 setCycle: End self)
			)
			(14
				(aCoil posn: 153 86 cel: 0 setCycle: End self show:)
				(gEgo view: 182 setCycle: Fwd)
			)
			(15
				(aCoil hide:)
				((View new:)
					view: 726
					loop: 1
					cel: 4
					posn: 153 86
					ignoreActors:
					addToPic:
				)
				(gEgo view: 183 cel: 0 posn: 156 85 setCycle: End self)
			)
			(16
				(aCoil posn: 153 70 cel: 0 setCycle: End self show:)
				(gEgo view: 182 setCycle: Fwd)
			)
			(17
				(aCoil hide:)
				((View new:)
					view: 726
					loop: 1
					cel: 4
					posn: 153 70
					ignoreActors:
					addToPic:
				)
				(gEgo view: 183 cel: 0 posn: 156 69 setCycle: End self)
			)
			(18
				(Print 81 18 #draw) ; "You made it!"
				(Print 81 19 #at -1 152) ; "(If you keep this up, you're going to be a hero yet, Larry!)"
				(Print 81 20) ; "Now, all you have to do is scale the sheer, vertical, basaltic cliffs of the volcano, reach its crater, and attempt to discover an entrance to the evil Dr. Nonookee's "impenetrable" fortress so you can learn what lies inside."
				(gEgo
					view: 100
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 156 2 self
				)
			)
			(19
				(NormalEgo)
				(gCurRoom newRoom: 181)
			)
			(20
				(= hasPissed 1)
				(gEgo setMotion: 0)
				(HandsOff)
				(aYellowName show: setCycle: End self)
			)
			(21
				(NormalEgo)
				(aYellowName hide:)
			)
		)
	)
)

