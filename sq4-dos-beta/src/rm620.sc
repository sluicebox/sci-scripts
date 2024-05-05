;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Motion)
(use Actor)
(use System)

(public
	rm620 0
)

(local
	local0
	local1
	local2
	[local3 45] = [0 0 0 0 100 55 0 119 40 5 87 16 0 43 45 5 21 7 0 98 45 1 154 67 2 212 7 3 170 10 4 145 11 5 105 5 0 98 28 5 113 12 -1 142 13]
)

(procedure (localproc_0)
	(Display 620 0 dsRESTOREPIXELS local1)
	(Display 620 0 dsRESTOREPIXELS local0)
)

(instance rm620 of SQRoom
	(properties
		picture 620
	)

	(method (init)
		(ulence roomVer: 11491)
		(SetFlag 16)
		(gEgo
			init:
			view: 625
			setLoop: 3
			normal: 0
			posn: 100 55
			setScript: flyScript
			setPri: 5
			illegalBits: -32768
			ignoreActors: 1
			setStep: 6 6
		)
		(mono1 init: setCel: 1 setPri: 4)
		(mono2 init: setPri: 4)
		(mono3 init: setPri: 4 setScript: mono3Script)
		(super init:)
		(self setRegions: 706) ; ulence
	)

	(method (doit)
		(if script 0)
		(super doit: &rest)
	)
)

(instance mono3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(mono1 setCel: 0)
				(mono3 setCycle: Fwd)
				(++ register)
				(switch register
					(1
						(= local0
							(Display
								{"Well, lookee here! If it ain't\nMister Look-at-me-I'm-in-VGA.\nWhatsamatter, monochrome not good enough for you?"}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								154
								5
								dsCOLOR
								global129
							)
						)
						(= local1
							(Display
								{"Well, lookee here! If it ain't\nMister Look-at-me-I'm-in-VGA.\nWhatsamatter, monochrome not good enough for you?"}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								155
								5
								dsCOLOR
								global130
							)
						)
					)
					(2
						(= local0
							(Display
								{"What's dis? 256 colors all for\none little bitmapped WIMP?!\nWhatta waste of VGA. Har, har!"}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								154
								5
								dsCOLOR
								global129
							)
						)
						(= local1
							(Display
								{"What's dis? 256 colors all for\none little bitmapped WIMP?!\nWhatta waste of VGA. Har, har!"}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								155
								5
								dsCOLOR
								global130
							)
						)
					)
					(3
						(= local0
							(Display
								{"Hey, fellas! I bet I can toss\nhim all the way out from the\nbottom o' the stairs. Bet ya\nan ale."_______________________}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								154
								5
								dsCOLOR
								global129
							)
						)
						(= local1
							(Display
								{"Hey, fellas! I bet I can toss\nhim all the way out from the\nbottom o' the stairs. Bet ya\nan ale."_______________________}
								dsWIDTH
								155
								dsALIGN
								alCENTER
								dsFONT
								4
								dsSAVEPIXELS
								dsCOORD
								155
								5
								dsCOLOR
								global130
							)
						)
					)
					(4
						(mono3 setScript: 0 setCycle: 0)
						(gEgo setScript: 0 setMotion: 0)
						(gLongSong fade:)
						(gCurRoom newRoom: 610)
					)
				)
				(= seconds (Random 5 10))
			)
			(2
				(localproc_0)
				(mono3 setCel: 0)
				(if (not local2)
					(= local2 1)
				else
					(mono1 setCycle: Fwd)
					(= local2 0)
				)
				(= seconds (Random 1 3))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance mono1 of Prop
	(properties
		x 77
		y 53
		view 625
		loop 4
	)
)

(instance mono2 of Prop
	(properties
		x 143
		y 27
		view 625
		loop 1
	)
)

(instance mono3 of Prop
	(properties
		x 229
		y 50
		view 625
	)
)

(instance flyScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(mono2 setCel: 1)
				(gEgo setCycle: End self)
			)
			(1
				(= cycles (Random 10 20))
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= cycles (Random 5 10))
			)
			(4
				(mono2 setCel: 0)
				(gEgo setCycle: End self)
			)
			(5
				(= cycles (Random 5 10))
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo setMotion: MoveTo 119 40 self)
			)
			(8
				(gEgo setMotion: MoveTo 87 16 self setPri: 3)
			)
			(9
				(gEgo setMotion: MoveTo 43 45 self)
			)
			(10
				(mono2 setCel: 5)
				(gEgo setMotion: MoveTo 21 7 self)
			)
			(11
				(gEgo setMotion: MoveTo 98 45 self setPri: 5)
			)
			(12
				(mono2 setCel: 1)
				(gEgo setMotion: MoveTo 154 67 self)
			)
			(13
				(gEgo setMotion: MoveTo 212 7 self)
			)
			(14
				(gEgo setMotion: MoveTo 170 10 self)
			)
			(15
				(mono2 setCycle: CT 3 1)
				(gEgo setMotion: MoveTo 145 11 self)
			)
			(16
				(gEgo setMotion: MoveTo 105 5 self)
			)
			(17
				(mono2 setCel: 0)
				(gEgo setMotion: MoveTo 98 28 self)
			)
			(18
				(mono2 setCel: 5)
				(gEgo setMotion: MoveTo 113 12 self)
			)
			(19
				(gEgo setMotion: MoveTo 142 13 self)
			)
			(20
				(mono2 setLoop: 2 setCycle: End self)
			)
			(21
				(= cycles (Random 5 10))
			)
			(22
				(gEgo hide:)
				(mono2 setCycle: Beg self)
			)
			(23
				(mono2 setLoop: 1 setCycle: CT 1 1)
				(= seconds 5)
			)
			(24
				(self dispose:)
			)
		)
	)
)

