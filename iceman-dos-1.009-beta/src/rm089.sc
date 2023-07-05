;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm089 0
)

(local
	local0
)

(instance rm089 of Rm
	(properties)

	(method (init)
		(LoadMany rsVIEW 89 189 289)
		(LoadMany rsFONT 3 999 2)
		(LoadMany rsSOUND 65 92)
		(super init:)
		(aBand init:)
		(aAdmiral init:)
		(if global132
			(aFlag1 init:)
			(aFlag2 init:)
			(aTower init:)
			(aEndWake init:)
			(aWake0 init:)
			(aWake1 init:)
			(aWake2 init:)
		else
			(gAddToPics add: aFlag1 aFlag2 species)
		)
		(self setScript: RoomScript)
		(gEgo view: 89 setLoop: 6 setCel: 0 posn: 193 114 setPri: 11 init:)
		(gAddToPics
			add: atpRow1 atpRow2 atpJet atpShipNumber atpOff2 atpOff1
			doit:
		)
		(HandsOff)
	)

	(method (dispose)
		(proc0_3)
		(super dispose: &rest)
	)
)

(instance RoomScript of Script
	(properties)

	(method (init)
		(gIceKeyDownHandler add: self)
		(gIceMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (theSong prevSignal:) -1) (== (RoomScript state:) 4))
				(theSong prevSignal: 0)
				(RoomScript changeState: 5)
			)
			((and (== (theSong prevSignal:) 5) (== (RoomScript state:) 1))
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 2)
			)
			((and (== (theSong prevSignal:) 6) (== (RoomScript state:) 2))
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 3)
			)
			((and (== (theSong prevSignal:) 7) (== (RoomScript state:) 3))
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 4)
			)
			((== (theSong prevSignal:) 10)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 6)
			)
			((== (theSong prevSignal:) 20)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 8)
			)
			((== (theSong prevSignal:) 30)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 10)
			)
			((== (theSong prevSignal:) 40)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 11)
			)
			((== (theSong prevSignal:) 50)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 16)
			)
			((== (theSong prevSignal:) 60)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 18)
			)
			((== (theSong prevSignal:) 70)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 22)
			)
			((and (== (theSong prevSignal:) 80) (== (RoomScript state:) 24))
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 25)
			)
			((== (theSong prevSignal:) 90)
				(theSong prevSignal: 0)
				(= cycles (= seconds 0))
				(RoomScript changeState: 26)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 89 7 1 0)
				(= seconds 2)
			)
			(1
				(aBand setCycle: Fwd)
				(theSong number: 65 loop: 1 play:)
				(Print 89 0 #at -1 140 #dispose) ; "The presentation is about to begin as you listen to the band play "Anchors Aweigh.""
			)
			(2
				(Print 89 1 #at -1 140 #dispose) ; "You wait with anticipation as the band continues to play."
			)
			(3
				(Print 89 2 #at -1 140 #dispose) ; "Your heart rate increases as the surrounding excitement pumps adrenaline into your blood."
			)
			(4
				(Print 89 3 #at -1 140 #dispose) ; "You hear someone shout the military command..."
			)
			(5
				(aBand setLoop: 9 setCel: 0)
				(theSong number: 92 loop: 1 play:)
				(Print 89 4 #at -1 140 #dispose) ; "ATTENTION!"
			)
			(6
				(Print 89 5 #at -1 140 #dispose) ; "With military discipline you come to attention with the rest of the ranks."
				(= seconds 2)
			)
			(7
				(aAdmiral setLoop: 0 setCel: 2)
			)
			(8
				(Print 89 6 #at -1 140 #dispose) ; "You return the salute of the Rear Admiral and then he speaks."
				(aAdmiral setLoop: 7 setCel: 0)
				(= seconds 2)
			)
			(9
				(gEgo setLoop: 6 setCel: 2)
			)
			(10
				(gEgo setCel: 0)
				(Print 89 7 #at -1 140 #dispose) ; "Commander John Westland! Because of your courageous effort, this mission has been a complete success!"
			)
			(11
				(Print 89 8 #at -1 140 #dispose) ; "Continuing he says, "The skills you so expertly demonstrated when taking emergency command of the USS Blackhawk have earned you the coveted "Gold Dolphins!""
				(aChest posn: 109 89 init:)
				(aPinner posn: 109 89 setCel: 0 init:)
				(= seconds 2)
			)
			(12
				(aPinner setCel: 1)
				(aSmallDolphin posn: 153 51 init:)
				(aDolphin posn: 53 50 init:)
				(= seconds 2)
			)
			(13
				(aPinner setCel: 0)
				(= seconds 2)
			)
			(14
				(aAdmiral setLoop: 7 cel: 0 setCycle: End)
				(= seconds 2)
			)
			(15
				(aAdmiral setLoop: 8 setCel: 0)
			)
			(16
				(Print 89 9 #at -1 140 #dispose) ; ""Further," the Rear Admiral says, "With great pride and honor, it is a pleasure to present to you The Naval Distinguished Service Medal."
				(aPinner setCel: 2)
				(aAdmiral cycleSpeed: 2 setLoop: 7 cel: 0 setCycle: End)
				(aMedal posn: 281 92 init:)
				(aSmallMedal posn: 201 82 init:)
				(= seconds 2)
			)
			(17
				(aPinner setCel: 0)
			)
			(18
				(aSmallMedal dispose:)
				(aSmallDolphin dispose:)
				(aPinner dispose:)
				(aChest dispose:)
				(aDolphin dispose:)
				(aMedal dispose:)
				(proc0_3)
				(Print 89 10 #at -1 140 #dispose) ; "The Rear Admiral salutes."
				(aAdmiral setLoop: 8 setCel: 0)
				(= seconds 3)
			)
			(19
				(aAdmiral setLoop: 7 setCel: 0)
				(= seconds 2)
			)
			(20
				(aAdmiral setLoop: 0 setCel: 2)
				(Print 89 11 #at -1 140 #dispose) ; "You proudly return the the Rear Admiral's sharp military salute."
				(= seconds 2)
			)
			(21
				(aAdmiral setLoop: 7 setCel: 0)
				(gEgo setCel: 2)
			)
			(22
				(Print 89 12 #at -1 140 #dispose) ; "In closing the Rear Admiral says, "Washington has ordered a field generated promotion to the rank of captain. Congratulations Captain Westland!""
				(= seconds 2)
			)
			(23
				(aAdmiral setLoop: 0 setCel: 2)
				(gEgo setCel: 2)
				(= seconds 2)
			)
			(24
				(aAdmiral setLoop: 7 setCel: 0)
				(gEgo setCel: 0)
			)
			(25
				(proc0_3)
				(aMedal dispose:)
				(aDolphin dispose:)
				(aMiddleJet init:)
				(aRightJet init:)
				(aLeftJet init:)
				(Print 89 13 #at -1 140 #dispose) ; "It's true love for sure as our hero tenderly kisses Stacy."
				(aKiss setLoop: 1 setCel: 0 init: setCycle: End)
			)
			(26
				(aKiss setLoop: 2 cel: 0 setCycle: End self)
			)
			(27
				(proc0_3)
				(aMiddleJet posn: 160 58 setCel: 0)
				(= cycles 4)
			)
			(28
				(aLeftJet posn: 162 57 setCel: 0)
				(aRightJet posn: 158 57 setCel: 0)
				(aMiddleJet posn: 159 58 setCel: 1)
				(= cycles 3)
			)
			(29
				(aRightJet posn: 154 57 setCel: 1)
				(aLeftJet posn: 162 57 setCel: 1)
				(aMiddleJet posn: 159 56 setCel: 2)
				(= cycles 2)
			)
			(30
				(aRightJet posn: 148 56 setCel: 2)
				(aLeftJet posn: 166 56 setCel: 2)
				(aMiddleJet posn: 160 54 setCel: 3)
				(= cycles 1)
			)
			(31
				(aRightJet posn: 141 53 setCel: 3)
				(aLeftJet posn: 170 54 setCel: 3)
				(aMiddleJet posn: 161 52 setCel: 4)
				(= cycles 1)
			)
			(32
				(aRightJet posn: 131 50 setCel: 4)
				(aLeftJet posn: 175 52 setCel: 4)
				(aMiddleJet posn: 161 49 setCel: 5)
				(= cycles 1)
			)
			(33
				(aRightJet posn: 119 46 setCel: 5)
				(aLeftJet posn: 184 48 setCel: 5)
				(aMiddleJet posn: 162 44 setCel: 6)
				(= cycles 1)
			)
			(34
				(aRightJet posn: 102 41 setCel: 6)
				(aLeftJet posn: 196 44 setCel: 6)
				(aMiddleJet posn: 164 37 setCel: 7)
				(= cycles 1)
			)
			(35
				(aRightJet posn: 84 36 setCel: 7)
				(aLeftJet posn: 211 38 setCel: 7)
				(aMiddleJet posn: 165 30 setCel: 8)
				(= cycles 1)
			)
			(36
				(aRightJet posn: 59 29 setCel: 8)
				(aLeftJet posn: 231 31 setCel: 8)
				(aMiddleJet posn: 168 19 setCel: 9)
				(= cycles 1)
			)
			(37
				(aRightJet posn: 35 22 setCel: 9)
				(aLeftJet posn: 256 20 setCel: 9)
				(aMiddleJet dispose:)
				(= cycles 1)
			)
			(38
				(aRightJet dispose:)
				(aLeftJet dispose:)
				(= seconds 3)
			)
			(39
				(= local0 (Display 89 14 dsCOORD 95 18 dsCOLOR 15 dsFONT 999 dsWIDTH 190 dsSAVEPIXELS)) ; "ADDITIONAL ARTISTS"
				(aCredit1 setLoop: 0 setCel: 0 posn: 84 35 init:)
				(aCredit2 setLoop: 0 setCel: 1 posn: 214 35 init:)
				(aCredit3 setCel: 2 setLoop: 0 posn: 100 47 init:)
				(aCredit4 setLoop: 0 setCel: 3 posn: 210 47 init:)
				(= seconds 5)
			)
			(40
				(Display 89 15 dsRESTOREPIXELS local0)
				(= cycles 4)
			)
			(41
				(= local0 (Display 89 16 dsCOORD 95 18 dsCOLOR 15 dsFONT 999 dsWIDTH 190 dsSAVEPIXELS)) ; "ADDITIONAL PROGRAMMERS"
				(aCredit1 setLoop: 1 setCel: 0 posn: 87 35 init:)
				(aCredit2 setLoop: 1 setCel: 1 posn: 217 35 init:)
				(aCredit3 setLoop: 1 setCel: 2 posn: 90 45 init:)
				(aCredit4 setLoop: 1 setCel: 3 posn: 220 45 init:)
				(= seconds 4)
			)
			(42
				(Display 89 15 dsRESTOREPIXELS local0)
				(= cycles 2)
			)
			(43
				(= local0 (Display 89 17 dsCOORD 90 18 dsCOLOR 15 dsFONT 999 dsWIDTH 190 dsSAVEPIXELS)) ; "THANK YOU FOR PLAYING ICEMAN"
				(aCredit1 dispose:)
				(aCredit2 dispose:)
				(aCredit3 dispose:)
				(aCredit4 dispose:)
			)
		)
	)
)

(instance aLeftJet of Act
	(properties
		y 1043
		x 137
		view 189
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setLoop: 4)
	)
)

(instance aMiddleJet of Act
	(properties
		y 1045
		x 148
		view 189
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setLoop: 3)
	)
)

(instance aRightJet of Act
	(properties
		y 1043
		x 159
		view 189
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setLoop: 5)
	)
)

(instance aWake0 of Prop
	(properties
		y 189
		x 132
		view 189
		signal 16384
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aWake1 of Prop
	(properties
		y 165
		x 103
		view 189
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aWake2 of Prop
	(properties
		y 143
		x 64
		view 189
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aEndWake of Prop
	(properties
		y 130
		x 33
		view 189
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aAdmiral of Prop
	(properties
		y 114
		x 180
		view 89
		loop 7
	)

	(method (init)
		(super init:)
		(self setPri: 12 ignoreActors:)
	)
)

(instance aTower of Prop
	(properties
		y 77
		x 17
		view 89
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd setPri: 3 cycleSpeed: 5)
	)
)

(instance aFlag1 of Prop
	(properties
		y 81
		x 172
		view 89
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 3 setCycle: Fwd)
	)
)

(instance aFlag2 of Prop
	(properties
		y 84
		x 128
		view 89
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 3 setCycle: Fwd)
	)
)

(instance aBand of Prop
	(properties
		y 109
		x 149
		view 89
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 3)
	)
)

(instance atpShipNumber of PV
	(properties
		y 144
		x 260
		view 89
		signal 16384
	)
)

(instance atpJet of PV
	(properties
		y 76
		x 77
		view 89
		cel 1
		priority 3
		signal 16384
	)
)

(instance atpRow1 of PV
	(properties
		y 145
		x 151
		view 89
		loop 2
		cel 1
		signal 16384
	)
)

(instance atpRow2 of PV
	(properties
		y 147
		x 134
		view 89
		loop 2
		cel 1
		signal 16384
	)
)

(instance atpOff1 of PV
	(properties
		y 120
		x 228
		view 89
		loop 2
		cel 3
		signal 16384
	)
)

(instance atpOff2 of PV
	(properties
		y 116
		x 246
		view 89
		loop 2
		cel 2
		priority 3
		signal 16384
	)
)

(instance aDolphin of View
	(properties
		y 1000
		x 53
		view 289
	)

	(method (init)
		(super init:)
		(self setPri: 4 ignoreActors:)
	)
)

(instance aMedal of View
	(properties
		y 1000
		x 281
		view 289
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 4 ignoreActors:)
	)
)

(instance aKiss of Prop
	(properties
		y 58
		x 158
		view 289
		loop 1
		cel 3
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit1 of View
	(properties
		y 1000
		x 1000
		view 489
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance aCredit2 of View
	(properties
		y 1000
		x 1000
		view 489
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance aCredit3 of View
	(properties
		y 1000
		x 1000
		view 489
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance aCredit4 of View
	(properties
		y 1000
		x 1000
		view 489
	)

	(method (init)
		(super init:)
		(self ignoreActors:)
	)
)

(instance theSong of Sound
	(properties
		priority 15
	)
)

(instance aChest of View
	(properties
		y 1000
		x 1000
		view 289
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors:)
	)
)

(instance aSmallDolphin of View
	(properties
		y 1000
		x 1000
		view 289
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aSmallMedal of View
	(properties
		y 1000
		x 1000
		view 289
		loop 5
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aPinner of Prop
	(properties
		y 1000
		x 1000
		view 289
		signal 16384
	)

	(method (init)
		(super init:)
		(self setLoop: 4 setPri: 15 setCel: 0)
	)
)

