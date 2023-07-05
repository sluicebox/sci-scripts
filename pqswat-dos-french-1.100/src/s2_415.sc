;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Motion)
(use Actor)
(use System)

(public
	s2_415 0
)

(instance s2_415 of PQRoom
	(properties
		picture 415
	)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(Palette 2 42 254 0) ; PalIntensity
				(gKeyDownHandler delete: self)
				(FrameOut)
				(event claimed: 1)
				(self setScript: skipItScript)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 232))
			(eastExit init:)
			(westExit init:)
		)
		(cond
			((or (IsFlag 223) (and (IsFlag 232) (IsFlag 231)))
				(gKeyDownHandler addToFront: self)
				(self setScript: sLineUp)
			)
			((IsFlag 232)
				(SetFlag 247)
				(if (IsFlag 125)
					(gKeyDownHandler addToFront: self)
					(self setScript: sCase2Script)
				else
					(Load rsVIEW 4150)
					(gKeyDownHandler addToFront: self)
					(self setScript: sEntry)
				)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance skipItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 60 loop: 0 play:)
				(gMessager say: 0 0 25 4 self 405) ; "The fat's in the fire... Pacmeyer, let's line 'em up."
			)
			(1
				(SetFlag 233)
				(gCurRoom newRoom: 4052) ; s2_405
			)
		)
	)
)

(instance sEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 21 2 self 405) ; "The owner of the warehouse is quite concerned with the status of her warehouseman. She and I spoke just moments ago and she verified the information we were putting together. The warehouseman is a Hispanic male, late twenties. His name is Hector Martinez. He's approximately six feet tall, a hundred and eighty pounds. We contacted his home and they confirmed he left for work at 6:30am. It's possible he's either the shooter or being held hostage by the shooter."
			)
			(1
				(cond
					((and (IsFlag 214) (IsFlag 213) (not (IsFlag 217)))
						(= next sCase1Script)
					)
					((and (IsFlag 214) (IsFlag 213) (IsFlag 217))
						(= next sCase2Script)
					)
					(else
						(= next sCase3Script)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sCase1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 10 1 self 405) ; "We have a general layout of the warehouse. We've placed sniper teams on three surrounding buildings."
				(snipe1 init:)
				(snipe2 init:)
				(snipe3 init:)
			)
			(1
				(snipe1 dispose:)
				(snipe2 dispose:)
				(snipe3 dispose:)
				(gMessager say: 0 0 10 2 self 405) ; "The approach will be from side four to three to two around to side one. We can assume opening one will be secured. I suggest we breach the door with a shotgun, one ounce slug. It's quicker and doesn't risk SID. We know it's a large space so we're issuing .223s. Does anybody have anything to add?"
				(= ticks 20)
			)
			(2
				(swatPath init: setCycle: End self)
			)
			(3 0)
			(4
				(swatPath dispose:)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 4052) ; s2_405
			)
		)
	)
)

(instance sCase2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 25 1 self 405) ; "The warehouse is broken into two rooms."
				(wareHouse init:)
				(= cycles 20)
			)
			(1
				(wallDivider init: setCycle: CT 14 1)
			)
			(2
				(gMessager say: 0 0 25 2 self 405) ; "In one of the rooms, which one we don't know, are stairs leading to a basement. The basement is dark, and it consists mainly of floor supports... There's also an office area. We've placed sniper teams on three surrounding buildings."
				(= ticks 660)
			)
			(3
				(wareHouse dispose:)
				(wallDivider cel: 15)
				(UpdateScreenItem wallDivider)
				(snipe1 init:)
				(snipe2 init:)
				(snipe3 init:)
			)
			(4
				(snipe1 dispose:)
				(snipe2 dispose:)
				(snipe3 dispose:)
				(gMessager say: 0 0 25 3 self 405) ; "The approach will be from side four to three to two around to side one. We can assume the opening one will be secured. We have the keys from the owner so there should not be a problem with entry unless the door is barricaded from the inside. We know it's a large space so we're issuing .223s."
				(swatPath init: setCycle: End self)
			)
			(5 0)
			(6
				(swatPath dispose:)
				(gFxSound number: 60 loop: 0 play:)
				(gMessager say: 0 0 25 4 self 405) ; "The fat's in the fire... Pacmeyer, let's line 'em up."
			)
			(7
				(= cycles 2)
			)
			(8
				(SetFlag 233)
				(gCurRoom newRoom: 4052) ; s2_405
			)
		)
	)
)

(instance sCase3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 25 1 self 405) ; "The warehouse is broken into two rooms."
				(wareHouse init:)
				(= cycles 20)
			)
			(1
				(wallDivider init: setCycle: CT 14 1)
			)
			(2
				(gMessager say: 0 0 25 2 self 405) ; "In one of the rooms, which one we don't know, are stairs leading to a basement. The basement is dark, and it consists mainly of floor supports... There's also an office area. We've placed sniper teams on three surrounding buildings."
				(= ticks 600)
			)
			(3
				(wareHouse dispose:)
				(wallDivider cel: 15)
				(UpdateScreenItem wallDivider)
				(snipe1 init:)
				(snipe2 init:)
				(snipe3 init:)
			)
			(4
				(snipe1 dispose:)
				(snipe2 dispose:)
				(snipe3 dispose:)
				(gMessager say: 0 0 28 3 self 405) ; "The approach will be from side four to three to two around to side one. We can assume the opening one will be secured. We have the warehouse keys from the owner. There should be no problem with entry unless the door is barricaded from the inside. We know it's a large space so we're issuing .223s."
				(swatPath init: setCycle: End self)
			)
			(5 0)
			(6
				(swatPath dispose:)
				(gFxSound number: 60 loop: 0 play:)
				(gMessager say: 0 0 28 4 self 405) ; "The fat's in the fire... Pacmeyer, line 'em up."
			)
			(7
				(= cycles 2)
			)
			(8
				(SetFlag 233)
				(gCurRoom newRoom: 4052) ; s2_405
			)
		)
	)
)

(instance sLineUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 231)
					(gMessager say: 5 29 0 0 self 405) ; "I spoke with the owner. She said the warehouse consists of two large rooms. She also said there's a basement to the building; however, there's no outside port to it. She also said she can't remember if the steps leading downstairs are in the first room or the second. She did say the basement is pretty dark."
					(wallDivider init: setCycle: End)
				else
					(self cue:)
				)
			)
			(1
				(ClearFlag 223)
				(ClearFlag 231)
				(gFxSound number: 60 loop: 0 play:)
				(gMessager say: 0 0 22 0 self 405) ; "The fat's in the fire... Pacmeyer, line 'em up."
			)
			(2
				(SetFlag 233)
				(gCurRoom newRoom: 4052) ; s2_405
			)
		)
	)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 4052) ; s2_405
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4052) ; s2_405
	)
)

(instance snipe1 of Prop
	(properties
		x 62
		y 32
		view 4150
	)
)

(instance snipe2 of Prop
	(properties
		x 62
		y 32
		view 4150
		loop 1
	)
)

(instance snipe3 of Prop
	(properties
		x 62
		y 32
		view 4150
		loop 2
	)
)

(instance swatPath of Prop
	(properties
		x 180
		y 162
		view 4150
		loop 5
	)
)

(instance wallDivider of Prop
	(properties
		x 307
		y 175
		view 4150
		loop 6
	)
)

(instance wareHouse of View
	(properties
		x 230
		y 169
		view 4150
		loop 3
	)
)

