;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use RandCycle)
(use Feature)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm48 0
)

(local
	local0
	local1
	local2 = 55
	local3 = 40
	local4 = 45
	[local5 10]
	local15
	local16 = 1
	local17
)

(procedure (localproc_0 param1)
	(= [local5 local15] [param1 0])
	(++ local15)
)

(procedure (localproc_1)
	(if (not (sellRobots register:))
		(= local15 0)
		(bugTalker state: 0 seconds: 0)
	)
)

(instance rm48 of Rm
	(properties
		picture 48
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init:)
		(bugMouth init:)
		(antenna init: stopUpd: setScript: wiggleAntenna)
		(rightarm init: setCycle: RandCycle setScript: bugTalker)
		(display init: stopUpd:)
		(readout init: stopUpd:)
		(bug init:)
		(award init:)
		(robotHead init:)
		(robotArm init:)
		(bugButt init:)
		(DBUsign init:)
		(screen init:)
		(diaphram init:)
		(tubes init:)
		(table init:)
		(parts init:)
		(self setScript: sellRobots)
		(gLongSong number: 623 loop: -1 play:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			((not (sellRobots register:))
				(bugTalker seconds: 0 cue:)
				(event claimed: 1)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(gCurRoom newRoom: 47)
				(event claimed: 1)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
					(== (gTheIconBar curInvIcon:) (Inv at: 10)) ; buckazoid
					(== (event message:) JOY_DOWNRIGHT)
				)
				(Print 48 0) ; "The salesbug would appreciate it if you'd give him the money. It would make his job soooo much easier."
			)
		)
	)

	(method (doit)
		(if (-- local16)
			(switch local17
				(0
					(Palette palANIMATE 64 73 (- (Random 0 30) 15))
				)
				(1
					(Palette palANIMATE 64 73 8)
				)
				(2
					(Palette palANIMATE 64 73 3)
				)
				(3
					(Palette palANIMATE 64 73 -3)
				)
				(4
					(Palette palANIMATE 64 73 -8)
				)
			)
		else
			(= local16 (Random 20 50))
			(= local17 (Random 0 4))
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance sellRobots of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 4 5)
				(localproc_0 1)
				(if (IsFlag 45)
					(localproc_0 2)
				else
					(localproc_0 3)
					(localproc_0 4)
					(localproc_0 5)
				)
				(= cycles 2)
			)
			(1
				(if register
					(= temp0 (display cel:))
					(if (and (OneOf (++ temp0) 10 1 4) (IsFlag 33))
						(++ temp0)
					)
					(display cel: temp0 forceUpd:)
					(readout cel: temp0 forceUpd:)
				)
				(= seconds 3)
			)
			(2
				(= start 1)
				(self init:)
			)
		)
	)
)

(instance bugTalker of Script
	(properties)

	(method (doit)
		(if (and local15 (== state 0))
			(sellRobots register: 0)
			(= seconds 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 250])
		(switch (= state newState)
			(0
				(if (not local15)
					(HandsOn)
					(gTheIconBar disable: 4 5)
				else
					(HandsOff)
				)
			)
			(1
				(GetFarText 821 [local5 (-- local15)] @temp0)
				(= register (proc0_12 @temp0 67 6 134 70 190 28 global136 33 60))
				(bugMouth setCycle: Fwd)
				(= seconds 10)
			)
			(2
				(cond
					((noMoney register:)
						(gCurRoom newRoom: 47)
					)
					((soldDroid register:)
						(gCurRoom newRoom: 46)
					)
					(else
						(proc0_12 register)
						(bugMouth setCycle: 0)
						(if (not local15)
							(sellRobots register: 1)
						)
						(self init:)
					)
				)
			)
		)
	)
)

(instance soldDroid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(localproc_0 6)
				(localproc_0 7)
				(= cycles 4)
			)
			(1
				(= register 1)
			)
		)
	)
)

(instance noMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(switch (++ local0)
					(1
						(localproc_0 8)
					)
					(2
						(localproc_0 9)
					)
					(3
						(localproc_0 10)
					)
					(else
						(localproc_0 11)
						(= register 1)
					)
				)
				(localproc_0 12)
				(self dispose:)
			)
		)
	)
)

(instance bug of Feature
	(properties
		y 189
		description {salesbug}
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 48 1) ; "The salesbug appears to be a Chdnarian, a race renowned for their predatory sales techniques. You decide to count your fingers once you've completed your transaction."
			)
			(5 ; Talk
				(localproc_1)
				(switch (display cel:)
					(0
						(localproc_0 13)
						(localproc_0 14)
						(localproc_0 15)
					)
					(1
						(localproc_0 16)
						(localproc_0 17)
						(localproc_0 18)
						(localproc_0 19)
					)
					(2
						(localproc_0 20)
						(localproc_0 21)
						(localproc_0 22)
						(localproc_0 23)
						(localproc_0 24)
					)
					(3
						(localproc_0 25)
						(localproc_0 26)
						(localproc_0 27)
					)
					(4
						(localproc_0 28)
						(localproc_0 29)
						(localproc_0 30)
						(localproc_0 31)
					)
					(5
						(localproc_0 32)
						(localproc_0 33)
						(localproc_0 34)
					)
					(6
						(localproc_0 35)
						(localproc_0 36)
						(localproc_0 37)
					)
					(7
						(localproc_0 38)
						(localproc_0 39)
						(localproc_0 40)
					)
					(8
						(localproc_0 41)
						(localproc_0 42)
						(localproc_0 43)
					)
					(9
						(localproc_0 44)
						(localproc_0 45)
					)
					(10
						(localproc_0 46)
						(localproc_0 47)
						(localproc_0 48)
						(localproc_0 49)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Cartridge
						(localproc_0 50)
					)
					(2 ; Gadget
						(localproc_0 51)
					)
					(4 ; Knife
						(localproc_0 52)
					)
					(5 ; Dehydrated_Water
						(Print)
					)
					(11 ; Jetpack
						(localproc_0 53)
						(localproc_0 54)
					)
					(18 ; Droids-B-Us_coupon
						(localproc_1)
						(= local1 1)
						(gEgo put: 18) ; Droids-B-Us_coupon
						(-= local2 9)
						(-= local3 9)
						(-= local4 9)
						(localproc_0 55)
					)
					(10 ; buckazoid
						(localproc_1)
						(switch (display cel:)
							(0
								(bugMouth setScript: noMoney)
							)
							(1
								(if (>= gBuckazoidCount local2)
									(-= gBuckazoidCount local2)
									(SetFlag 32)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
							(2
								(bugMouth setScript: noMoney)
							)
							(3
								(localproc_0 56)
							)
							(4
								(if (>= gBuckazoidCount local3)
									(-= gBuckazoidCount local3)
									(SetFlag 44)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
							(5
								(bugMouth setScript: noMoney)
							)
							(6
								(localproc_0 57)
							)
							(7
								(bugMouth setScript: noMoney)
							)
							(8
								(bugMouth setScript: noMoney)
							)
							(9
								(localproc_0 58)
							)
							(10
								(if (>= gBuckazoidCount local4)
									(-= gBuckazoidCount local4)
									(SetFlag 25)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
						)
					)
					(else
						(localproc_0 59)
						(localproc_0 60)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance antenna of Prop
	(properties
		x 198
		y 60
		description {antenna}
		view 148
		cel 2
		priority 12
		signal 16400
		cycleSpeed 30
	)
)

(instance wiggleAntenna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Osc (Random 1 3) self)
			)
			(1
				(= cycles (Random 10 24))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance bugMouth of Prop
	(properties
		x 195
		y 91
		view 148
		loop 1
		priority 8
		signal 16400
		cycleSpeed 12
	)
)

(instance rightarm of Prop
	(properties
		x 264
		y 97
		view 148
		loop 2
		priority 1
		signal 16400
		cycleSpeed 24
		detailLevel 2
	)
)

(instance display of View
	(properties
		x 87
		y 93
		view 248
		signal 16400
	)
)

(instance readout of View
	(properties
		x 83
		y 112
		view 248
		loop 1
		signal 16400
	)
)

(instance award of Feature
	(properties
		y 189
		description {plaque}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 2) ; "The plaque says: "Salesbug of the year"! You'd better watch your money around this guy."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robotHead of Feature
	(properties
		y 189
		description {robot head}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 3) ; "Yikes! It's an Ultron-17, the only robot bad enough to go head-to-head with an Arnoid-1000 Exterminator. You note with relief that he appears to be out of commission, at least temporarily."
			)
			(5 ; Talk
				(Print 48 4) ; "The robot doesn't speak, but you think you can see a bloodthirsty gleam in his metallic eye."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robotArm of Feature
	(properties
		y 189
		description {robot apendage}
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 5) ; "That's an upgrade option for the Arnoid series. It's capable of crushing a person's skull. Very useful if you're in that line of work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bugButt of Feature
	(properties
		y 200
		description {exit button}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 6) ; "Click on this to leave Droids-B-Us."
			)
			(3 ; Do
				(gCurRoom newRoom: 47)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance DBUsign of Feature
	(properties
		y 189
		description {sign}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 7) ; "The plastoid letters on the wall spell out: "Droids-B-Us""
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Feature
	(properties
		y 189
		description {view screen}
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 8) ; "The viewscreen shows pictures of droids currently available in your rather limited price range."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance diaphram of Feature
	(properties
		y 189
		description {diaphram}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 9) ; "It looks like some sort of gigantic... diaphragm?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubes of Feature
	(properties
		y 189
		description {power tubes}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 10) ; "These tubes on the wall are power conduits."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		y 189
		description {work table}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 11) ; "There are many robotic parts scattered about the work table."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance parts of Feature
	(properties
		y 189
		description {robot parts}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 48 12) ; "Many parts, bits, and pieces of robotic paraphanalia adorn the walls of this small store."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

