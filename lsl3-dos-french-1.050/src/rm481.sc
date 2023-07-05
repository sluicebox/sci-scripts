;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 481)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm481 0
)

(local
	[string 200]
)

(procedure (Print481 &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		0
		70
		#width
		125
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm481 of Rm
	(properties
		picture 485
		horizon 5
	)

	(method (init)
		(HandsOff)
		(Load rsPIC 99)
		(Load rsVIEW 54)
		(Load rsFONT 7)
		(Load rsSOUND 484)
		(Load rsSOUND 485)
		(SL disable:)
		(TheMenuBar hide:)
		(gMusic number: 484 loop: 2 play:)
		(super init:)
		(self setScript: RoomScript)
		(aThermometerP setCycle: End init: setPri: 13)
		(aThermometerL setCycle: End init: setPri: 13)
		(gTheWindow color: 7 back: 0)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event claimed:) 0)
				(== (event message:) KEY_F8)
			)
			(Print 481 0) ; "Skipping ahead..."
			(SetFlag 69)
			(gCurRoom newRoom: 484)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 33)
			)
			(1
				(Format @string 481 1) ; ""Oh, Larry!"%"
				(= seconds (Print481))
			)
			(2
				(Format @string 481 2) ; ""Yes, yes! Oh, Larry! That's wonderful!! I didn't know pectorals could pulsate like that!"%"
				(= seconds (Print481))
			)
			(3
				(Format @string 481 3) ; "You think to yourself, "How ironic! Of all (both) the women I've known, this piano-player turns out to be the greatest!"%"
				(= seconds (Print481))
			)
			(4
				(Format @string 481 4) ; "Patti thinks to herself, "How ironic! Of all the men I've had, this dork turns out to be the greatest!"%"
				(= seconds (Print481))
			)
			(5
				(Format @string 481 5) ; "Simultaneously, you each murmur into the other's ear, "I never knew it could be this good!"%"
				(= seconds (Print481))
			)
			(6
				(gCurRoom drawPic: 99 6)
				(gMusic number: 485 loop: 2 play:)
				(aThermometerP setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(aThermometerL setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 55)
			)
			(7
				(Print 481 6 #font 7 #at 0 90 #width 125 #time (LangSwitch 3 3 6 6) #dispose) ; "YES!!"
				(aThermometerP
					setLoop: 0
					setCel: 255
					cycleSpeed: 2
					setCycle: Beg
				)
				(aThermometerL
					setLoop: 0
					setCel: 255
					cycleSpeed: 2
					setCycle: Beg
				)
				(= cycles 55)
			)
			(8
				(aThermometerP dispose:)
				(aThermometerL dispose:)
				(= cycles 33)
			)
			(9
				(Format @string 481 7) ; "As Patti drifts off to sleep, you realize: this is one woman who deserves her nickname!%"
				(= seconds (Print481))
			)
			(10
				(gCurRoom newRoom: 482)
			)
		)
	)
)

(instance aThermometerP of Prop
	(properties
		y 189
		x 181
		view 54
		cycleSpeed 12
	)
)

(instance aThermometerL of Prop
	(properties
		y 54
		x 101
		view 54
		cycleSpeed 12
	)
)

