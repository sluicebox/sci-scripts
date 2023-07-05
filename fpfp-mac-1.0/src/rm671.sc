;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 671)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Feature)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	rm671 0
)

(local
	local0
)

(instance rm671 of FPRoom
	(properties
		noun 29
		picture 671
	)

	(method (init &tmp temp0)
		(gEgo init: signal: 16384 wearingGuns: 1 get: -1 44) ; Pistols
		(= global146 0)
		(gTheIconBar disable: 0)
		(gTimers delete: (ScriptID 0 13)) ; deathTimer
		(= gCurPuzzle 21)
		(LoadMany
			rsSOUND
			2944
			2124
			2800
			2801
			2802
			2803
			2804
			2805
			2807
			2809
			2810
			2811
		)
		(super init:)
		(bullet init: hide:)
		(shwing init: hide:)
		(chips init: addToPic:)
		(aces init: stopUpd:)
		(chandelier2 init: stopUpd:)
		(sheep init: stopUpd:)
		(chick init: stopUpd:)
		(ruben init: stopUpd:)
		(cigman init: stopUpd:)
		(zircon init: stopUpd:)
		(shieldTable init: stopUpd:)
		(chair1 addToPic:)
		(chair2 addToPic:)
		(chair3 addToPic:)
		(chair4 addToPic:)
		(pokerTable init: addToPic:)
		(pokerGuy1 init: stopUpd:)
		(pokerGuy2 init: stopUpd:)
		(pokerGuy3 init: stopUpd:)
		(pokerGuy4 init: stopUpd:)
		(backDoor init: addToPic:)
		(rail init: setOnMeCheck: 1 2)
		(bar init: setOnMeCheck: 1 4)
		(bottles init: setOnMeCheck: 1 8)
		(painting2 init: setOnMeCheck: 1 16)
		(littlePic init: setOnMeCheck: 1 32)
		(piano init: setOnMeCheck: 1 64)
		(chandelier init: setOnMeCheck: 1 128)
		(dontShoot init: setOnMeCheck: 1 256)
		(= global146 0)
		(gCurRoom setScript: sDiveForCover)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(if (> gMouseX 100)
					(gCurRoom setScript: sFreddyShotsAcesWrong)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sArrestAces of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(gEgo setLoop: 5 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 38
					y: 139
					setLoop: 7
					setCel: 0
					setMotion: MoveTo 7 148 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 7 148 setCel: 0 show: setCycle: End)
				(bullet setCel: 5 setMotion: MoveTo 226 13 self)
			)
			(3
				(bullet hide:)
				(shwing hide:)
				(= cycles 1)
			)
			(4
				(chandSound number: 2760 play: self)
				(chandelier2
					view: 676
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End
				)
			)
			(5
				(chandSound number: 2807 play:)
				(chandelier2 y: 0 z: 0 setMotion: MoveTo 223 58 self)
			)
			(6
				(aces dispose:)
				(chips dispose:)
				(chandSound number: 2761 play: self)
				(chandelier2
					view: 676
					x: 221
					y: 141
					setLoop: 1
					setCel: 0
					setCycle: End
				)
			)
			(7
				(= cycles 30)
				(gGameMusic1 number: 672 flags: 1 loop: 1 play:)
				(= cycles 1)
			)
			(8
				(gCast eachElementDo: #dispose)
				(gCurRoom style: 10 drawPic: 780)
				(= cycles 1)
			)
			(9
				(SetFlag 85)
				(ClearFlag 59)
				(= global138 0)
				(= gCurPuzzle 22)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				(= cycles 1)
			)
			(10
				(gGame points: 20)
				(gMessager say: 46 0 0 1 self) ; "He did it! What a MANLY man! Riverboat gambler in the corner pocket!"
			)
			(11
				(chandSound number: 2919 play:)
				(gMessager say: 46 0 0 2 4 self) ; "Yee-hawwww!"
			)
			(12
				(gGameMusic1 fade:)
				(gEgo state: 2)
				(gCurRoom newRoom: 670)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyShotsAcesWrong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 2944)
				(gEgo
					view: 677
					setLoop: 0
					setCel: 0
					x: 67
					y: 163
					cycleSpeed: 12
					setCycle: End self
				)
				(aces
					view: 689
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gunSound number: 2944 play:)
			)
			(2
				(gunSound number: 2944 play:)
				(= cycles 1)
			)
			(3
				(gEgo
					view: 677
					setLoop: 6
					setCel: 0
					x: 67
					y: 163
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sDiveForCover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 681
					x: 147
					y: 163
					setLoop: 4
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 1)
			)
			(1
				(diveSound number: 2743 play:)
				(pokerGuy1 setCycle: End self)
			)
			(2
				(pChair1 init: stopUpd:)
				(pokerGuy1 dispose:)
				(= cycles 1)
			)
			(3
				(diveSound number: 2743 play:)
				(pokerGuy2 setCycle: End self)
			)
			(4
				(pChair2 init: stopUpd:)
				(pokerGuy2 dispose:)
				(= cycles 1)
			)
			(5
				(diveSound number: 2743 play:)
				(pokerGuy3 setCycle: End self)
			)
			(6
				(pChair3 init: stopUpd:)
				(pokerGuy3 dispose:)
				(= cycles 1)
			)
			(7
				(diveSound number: 2743 play:)
				(pokerGuy4 setCycle: End self)
			)
			(8
				(pChair4 init: stopUpd:)
				(pokerGuy4 dispose:)
				(UnLoad 128 672)
				(= cycles 1)
			)
			(9
				(gEgo hide:)
				(shieldTable
					view: 687
					setLoop: 0
					setCel: 0
					x: 147
					y: 163
					setCycle: CT 3 1 self
				)
			)
			(10
				(diveSound number: 2809 play:)
				(shieldTable setCycle: End self)
			)
			(11
				(diveSound number: 2810 play:)
				(shieldTable view: 687 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(shieldTable view: 689 setLoop: 1 setCel: 0 stopUpd:)
				(gEgo
					view: 677
					x: 67
					y: 163
					priority: 10
					signal: 16400
					setLoop: 1
					setCel: 0
					setMotion: 0
					setCycle: 0
					state: 0
					show:
				)
				(UnLoad 128 687)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sRewindLines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 679)
				(line1 init: hide:)
				(line1a init: hide:)
				(line2 init: hide:)
				(line2a init: hide:)
				(line3 init: hide:)
				(line3a init: hide:)
				(line4 init: hide:)
				(line4a init: hide:)
				(line5 init: hide:)
				(line5a init: hide:)
				(line6 init: hide:)
				(line6a init: hide:)
				(line7 init: hide:)
				(line7a init: hide:)
				(line8 init: hide:)
				(line8a init: hide:)
				(= cycles 20)
			)
			(1
				(gGame setCursor: 999 1)
				(Print
					posn: 100 70
					font: gUserFont
					window: SysWindow
					addTitle: 62 0 0 2 670
					addText: 62 0 0 3 2 2 670 ; "Be Kind! Please Rewind!"
					addButton: 0 62 0 0 1 70 20 670 ; "Rewind"
					init:
				)
				(= cycles 1)
			)
			(2
				(gGame setCursor: 997 1)
				(line1 show:)
				(line1a show:)
				(switch client
					(sheep
						(gCurRoom setScript: sKilledSheepBackwards)
					)
					(chick
						(gCurRoom setScript: sKilledChickBackwards)
					)
					(ruben
						(gCurRoom setScript: sKilledRubyBackwards)
					)
					(cigman
						(gCurRoom setScript: sKilledCigmanBackwards)
					)
					(zircon
						(gCurRoom setScript: sKilledZirconBackwards)
					)
				)
				(= cycles 1)
			)
			(3
				(line1 hide:)
				(line1a hide:)
				(line4 show:)
				(line4a show:)
				(= cycles 1)
			)
			(4
				(line4 hide:)
				(line4a hide:)
				(line8 show:)
				(line8a show:)
				(= cycles 1)
			)
			(5
				(line8 hide:)
				(line8a hide:)
				(line2 show:)
				(line2a show:)
				(= cycles 1)
			)
			(6
				(line2 hide:)
				(line2a hide:)
				(line5 show:)
				(line5a show:)
				(= cycles 1)
			)
			(7
				(line5 hide:)
				(line5a hide:)
				(line7 show:)
				(line7a show:)
				(= cycles 1)
			)
			(8
				(line7 hide:)
				(line7a hide:)
				(line6 show:)
				(line6a show:)
				(= cycles 1)
			)
			(9
				(line6 hide:)
				(line6a hide:)
				(line3 show:)
				(line3a show:)
				(= cycles 1)
			)
			(10
				(line3 hide:)
				(line3a hide:)
				(if (!= local0 1)
					(self changeState: 3)
				else
					(switch client
						(sheep
							(client view: 674 setLoop: 0 stopUpd:)
							(UnLoad 128 695)
						)
						(chick
							(client view: 674 setLoop: 1 stopUpd:)
							(UnLoad 128 696)
						)
						(ruben
							(client view: 674 setLoop: 2 stopUpd:)
							(UnLoad 128 697)
						)
						(cigman
							(client view: 674 setLoop: 3 stopUpd:)
							(UnLoad 128 698)
						)
						(zircon
							(client view: 674 setLoop: 4 stopUpd:)
							(UnLoad 128 699)
						)
					)
					(shwing hide:)
					(line1 dispose:)
					(line1a dispose:)
					(line2 dispose:)
					(line2a dispose:)
					(line3 dispose:)
					(line3a dispose:)
					(line4 dispose:)
					(line4a dispose:)
					(line5 dispose:)
					(line5a dispose:)
					(line6 dispose:)
					(line6a dispose:)
					(line7 dispose:)
					(line7a dispose:)
					(line8 dispose:)
					(line8a dispose:)
					(gGame handsOn: setCursor: 10 1)
					(gTheIconBar disable: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sKilledSheep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo setLoop: 4 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 43
					y: 123
					setLoop: 7
					setCel: 4
					setMotion: MoveTo 18 89 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 18 89 setCel: 0 show: setCycle: End)
				(bullet setCel: 5 setMotion: MoveTo 128 34 self)
			)
			(3
				(gunSound number: 2124 play:)
				(shwing posn: 128 34 setCel: 0 setCycle: End)
				(bullet setCel: 7 setMotion: MoveTo 290 115 self)
			)
			(4
				(bullet hide:)
				(shwing hide:)
				(deadSound number: 2800 play:)
				(client view: 695 setCycle: End self)
			)
			(5
				(client setScript: sRewindLines)
				(self dispose:)
			)
		)
	)
)

(instance sKilledSheepBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 678 play:)
				(deadSound number: 2805 play:)
				(sheep setCycle: Beg self)
			)
			(1
				(bullet
					x: 290
					y: 115
					setLoop: 7
					setCel: 7
					setMotion: MoveTo 128 34 self
					show:
				)
			)
			(2
				(gunSound number: 2811 play:)
				(shwing posn: 128 34 show: setCel: 6 setCycle: Beg)
				(bullet setCel: 5 setMotion: MoveTo 18 89 self)
			)
			(3
				(gunSound number: 2811 play:)
				(shwing posn: 18 89 setCel: 6 setCycle: Beg)
				(bullet setCel: 4 setMotion: MoveTo 43 123 self)
			)
			(4
				(bullet hide:)
				(gunSound number: 2814 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGameMusic1 number: 677 play:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sKilledChick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo setLoop: 2 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 53
					y: 119
					setLoop: 7
					setCel: 2
					setMotion: MoveTo 129 31 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 129 31 setCel: 0 show: setCycle: End)
				(bullet setCel: 1 setMotion: MoveTo 301 61 self)
			)
			(3
				(gunSound number: 2124 play:)
				(shwing posn: 301 61 setCel: 0 setCycle: End)
				(bullet setCel: 0 setMotion: MoveTo 131 79 self)
			)
			(4
				(bullet hide:)
				(shwing hide:)
				(deadSound number: 2802 play:)
				(client view: 696 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(client setScript: sRewindLines)
				(self dispose:)
			)
		)
	)
)

(instance sKilledChickBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 678 play:)
				(deadSound number: 2804 play:)
				(chick setCycle: Beg self)
			)
			(1
				(bullet
					x: 131
					y: 79
					setLoop: 7
					setCel: 0
					setMotion: MoveTo 301 61 self
					show:
				)
			)
			(2
				(gunSound number: 2811 play:)
				(shwing posn: 301 61 setCel: 6 show: setCycle: Beg)
				(bullet setCel: 1 setMotion: MoveTo 129 31 self)
			)
			(3
				(gunSound number: 2811 play:)
				(shwing posn: 129 31 setCel: 6 setCycle: Beg)
				(bullet setCel: 2 setMotion: MoveTo 53 119 self)
			)
			(4
				(bullet hide:)
				(gunSound number: 2814 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGameMusic1 number: 677 play:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sKilledRuby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo setLoop: 4 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 43
					y: 123
					setLoop: 7
					setCel: 4
					setMotion: MoveTo 10 51 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 10 51 setCel: 0 show: setCycle: End)
				(bullet setCel: 5 setMotion: MoveTo 128 30 self)
			)
			(3
				(gunSound number: 2124 play:)
				(shwing posn: 128 30 setCel: 0 setCycle: End)
				(bullet setCel: 7 setMotion: MoveTo 243 79 self)
			)
			(4
				(bullet hide:)
				(shwing hide:)
				(deadSound number: 2932 play:)
				(client view: 697 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(client setScript: sRewindLines)
				(self dispose:)
			)
		)
	)
)

(instance sKilledRubyBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 678 play:)
				(deadSound number: 2945 play:)
				(ruben setCycle: Beg self)
			)
			(1
				(bullet
					x: 243
					y: 79
					setLoop: 7
					setCel: 7
					setMotion: MoveTo 128 30 self
					show:
				)
			)
			(2
				(gunSound number: 2811 play:)
				(shwing posn: 128 30 show: setCel: 6 setCycle: Beg)
				(bullet setCel: 5 setMotion: MoveTo 10 51 self)
			)
			(3
				(gunSound number: 2811 play:)
				(shwing posn: 10 51 setCel: 6 setCycle: Beg)
				(bullet setCel: 4 setMotion: MoveTo 43 123 self)
			)
			(4
				(bullet hide:)
				(gunSound number: 2814 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGameMusic1 number: 677 play:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sKilledCigman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo setLoop: 3 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 51
					y: 119
					setLoop: 7
					setCel: 4
					setMotion: MoveTo 32 38 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 32 38 setCel: 0 show: setCycle: End)
				(bullet setCel: 1 setMotion: MoveTo 308 85 self)
			)
			(3
				(gunSound number: 2124 play:)
				(shwing posn: 308 85 setCel: 0 setCycle: End)
				(bullet setCel: 0 setMotion: MoveTo 7 148 self)
			)
			(4
				(gunSound number: 2124 play:)
				(shwing posn: 7 148 show: setCel: 6 setCycle: Beg)
				(bullet setCel: 1 setMotion: MoveTo 240 156 self)
			)
			(5
				(shwing hide:)
				(bullet hide:)
				(deadSound number: 2801 play:)
				(client view: 698 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(client setScript: sRewindLines)
				(self dispose:)
			)
		)
	)
)

(instance sKilledCigmanBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 678 play:)
				(deadSound number: 2803 play:)
				(cigman setCycle: Beg self)
			)
			(1
				(bullet
					x: 240
					y: 156
					setLoop: 7
					setCel: 1
					setMotion: MoveTo 7 148 self
					show:
				)
			)
			(2
				(gunSound number: 2811 play:)
				(shwing posn: 7 148 show: setCel: 6 setCycle: Beg)
				(bullet setCel: 0 setMotion: MoveTo 308 85 self)
			)
			(3
				(gunSound number: 2811 play:)
				(shwing posn: 308 85 setCel: 6 setCycle: Beg)
				(bullet setCel: 1 setMotion: MoveTo 32 38 self)
			)
			(4
				(gunSound number: 2811 play:)
				(shwing posn: 32 38 setCel: 6 setCycle: Beg)
				(bullet setLoop: 7 setCel: 4 setMotion: MoveTo 51 119 self)
			)
			(5
				(bullet hide:)
				(gunSound number: 2814 play:)
				(gEgo setCycle: Beg self)
			)
			(6
				(gGameMusic1 number: 677 play:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sKilledZircon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo setLoop: 3 setCycle: End self)
			)
			(1
				(gunSound number: 2944 play:)
				(bullet
					x: 51
					y: 119
					setLoop: 7
					setCel: 4
					setMotion: MoveTo 49 80 self
					show:
				)
			)
			(2
				(gunSound number: 2124 play:)
				(shwing posn: 49 80 setCel: 6 show: setCycle: End)
				(bullet setCel: 1 setMotion: MoveTo 308 65 self)
			)
			(3
				(gunSound number: 2124 play:)
				(shwing posn: 308 65 setCel: 6 setCycle: End)
				(bullet setCel: 0 setMotion: MoveTo 66 108 self)
			)
			(4
				(bullet hide:)
				(shwing hide:)
				(deadSound number: 2801 play:)
				(client view: 699 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(client setScript: sRewindLines)
				(self dispose:)
			)
		)
	)
)

(instance sKilledZirconBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deadSound number: 2803 play:)
				(gGameMusic1 number: 678 play:)
				(zircon setCycle: Beg self)
			)
			(1
				(bullet
					x: 66
					y: 108
					setLoop: 7
					setCel: 0
					setMotion: MoveTo 308 65 self
					show:
				)
			)
			(2
				(gunSound number: 2811 play:)
				(shwing posn: 308 65 show: setCel: 6 setCycle: Beg)
				(bullet setCel: 1 setMotion: MoveTo 49 80 self)
			)
			(3
				(gunSound number: 2811 play:)
				(shwing posn: 49 80 setCel: 6 setCycle: Beg)
				(bullet setCel: 4 setMotion: MoveTo 51 119 self)
			)
			(4
				(bullet hide:)
				(gunSound number: 2814 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGameMusic1 number: 677 play:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance chandelier2 of Actor
	(properties
		x 221
		y 135
		z 137
		noun 29
		yStep 10
		view 670
		loop 2
		priority 9
		signal 24593
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance aces of Prop
	(properties
		x 224
		y 191
		z 69
		noun 31
		view 672
		loop 4
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch global146
					(0
						(gMessager say: noun theVerb 1) ; "Give yourself up, Aces! I caught you red-handed!"
						(++ global146)
					)
					(1
						(gMessager say: noun theVerb 2) ; "Drop your gun and give up! You can't win!"
						(++ global146)
					)
					(2
						(gMessager say: noun theVerb 3) ; "I'm going to count to three, and when I reach three, you'd better have your hands in the air!"
					)
				)
			)
			(47 ; Pistols
				(gCurRoom setScript: sFreddyShotsAcesWrong)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pokerGuy1 of Prop
	(properties
		x 180
		y 149
		view 681
		signal 16384
	)
)

(instance pokerGuy2 of Prop
	(properties
		x 267
		y 147
		view 681
		loop 1
		signal 16384
	)
)

(instance pokerGuy3 of Prop
	(properties
		x 255
		y 167
		view 681
		loop 2
		signal 16384
	)
)

(instance pokerGuy4 of Prop
	(properties
		x 191
		y 164
		view 681
		loop 3
		priority 11
		signal 16400
	)
)

(instance sheep of Prop
	(properties
		x 296
		y 134
		noun 29
		view 674
		priority 10
		signal 16400
	)
)

(instance chick of Prop
	(properties
		x 129
		y 114
		noun 29
		view 674
		loop 1
		signal 16384
		scaleSignal 1
		scaleX 102
		scaleY 102
	)
)

(instance ruben of Prop
	(properties
		x 244
		y 110
		noun 29
		view 674
		loop 2
		signal 16384
		scaleSignal 1
		scaleX 106
		scaleY 106
	)
)

(instance cigman of Prop
	(properties
		x 244
		y 188
		noun 29
		view 674
		loop 3
		signal 16384
	)
)

(instance zircon of Prop
	(properties
		x 65
		y 134
		noun 29
		view 674
		loop 4
		signal 16384
		scaleSignal 1
		scaleX 113
		scaleY 113
	)
)

(instance shwing of Prop
	(properties
		view 677
		loop 8
		priority 14
		signal 16400
	)
)

(instance backDoor of View
	(properties
		x 213
		y 89
		noun 29
		view 670
		signal 16384
	)
)

(instance pokerTable of View
	(properties
		x 228
		y 129
		noun 29
		approachX 232
		approachY 174
		view 678
		loop 5
		priority 11
		signal 16400
	)
)

(instance pChair1 of View
	(properties
		x 189
		y 129
		noun 29
		view 678
		priority 10
		signal 16400
	)
)

(instance pChair2 of View
	(properties
		x 264
		y 126
		noun 29
		view 678
		loop 1
		priority 10
		signal 16400
	)
)

(instance pChair3 of View
	(properties
		x 268
		y 152
		noun 29
		view 678
		loop 2
		priority 12
		signal 16400
	)
)

(instance pChair4 of View
	(properties
		x 162
		y 164
		noun 29
		view 678
		loop 3
		priority 12
		signal 16400
	)
)

(instance shieldTable of Prop
	(properties
		x 120
		y 129
		noun 29
		view 678
		loop 5
		priority 11
		signal 16400
	)
)

(instance chair1 of View
	(properties
		x 95
		y 120
		noun 29
		view 678
		priority 10
		signal 16400
	)
)

(instance chair2 of View
	(properties
		x 153
		y 118
		noun 29
		view 678
		loop 1
		priority 10
		signal 16400
	)
)

(instance chair3 of View
	(properties
		x 129
		y 163
		noun 29
		view 678
		loop 2
		priority 12
		signal 16400
	)
)

(instance chair4 of View
	(properties
		x 90
		y 160
		noun 29
		view 678
		loop 3
		priority 12
		signal 16400
	)
)

(instance chips of View
	(properties
		x 226
		y 129
		noun 29
		view 672
		loop 5
		priority 12
		signal 16400
	)
)

(instance bullet of Actor
	(properties
		x 89
		y 120
		yStep 10
		view 677
		loop 7
		priority 14
		signal 16400
		illegalBits 0
		xStep 20
	)
)

(instance line1 of View
	(properties
		y 30
		view 679
		priority 15
		signal 16400
	)
)

(instance line2 of View
	(properties
		y 59
		view 679
		loop 1
		priority 15
		signal 16400
	)
)

(instance line3 of View
	(properties
		y 76
		view 679
		loop 2
		priority 15
		signal 16400
	)
)

(instance line4 of View
	(properties
		y 101
		view 679
		loop 3
		priority 15
		signal 16400
	)
)

(instance line5 of View
	(properties
		y 112
		view 679
		loop 4
		priority 15
		signal 16400
	)
)

(instance line6 of View
	(properties
		y 125
		view 679
		loop 5
		priority 15
		signal 16400
	)
)

(instance line7 of View
	(properties
		y 144
		view 679
		loop 6
		priority 15
		signal 16400
	)
)

(instance line8 of View
	(properties
		y 174
		view 679
		loop 7
		priority 15
		signal 16400
	)
)

(instance line1a of View
	(properties
		x 159
		y 30
		view 679
		cel 1
		priority 15
		signal 16400
	)
)

(instance line2a of View
	(properties
		x 159
		y 59
		view 679
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance line3a of View
	(properties
		x 159
		y 76
		view 679
		loop 2
		cel 1
		priority 15
		signal 16400
	)
)

(instance line4a of View
	(properties
		x 159
		y 101
		view 679
		loop 3
		cel 1
		priority 15
		signal 16400
	)
)

(instance line5a of View
	(properties
		x 159
		y 112
		view 679
		loop 4
		cel 1
		priority 15
		signal 16400
	)
)

(instance line6a of View
	(properties
		x 159
		y 125
		view 679
		loop 5
		cel 1
		priority 15
		signal 16400
	)
)

(instance line7a of View
	(properties
		x 159
		y 144
		view 679
		loop 6
		cel 1
		priority 15
		signal 16400
	)
)

(instance line8a of View
	(properties
		x 159
		y 174
		view 679
		loop 7
		cel 1
		priority 15
		signal 16400
	)
)

(instance rail of Feature
	(properties
		x 26
		y 190
		noun 63
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gCurRoom setScript: sArrestAces)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bar of Feature
	(properties
		x 26
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(sheep setScript: sKilledSheep)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottles of Feature
	(properties
		x 12
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(sheep setScript: sKilledSheep)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance painting2 of Feature
	(properties
		x 7
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(ruben setScript: sKilledRuby)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance littlePic of Feature
	(properties
		x 32
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(cigman setScript: sKilledCigman)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance piano of Feature
	(properties
		x 47
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(zircon setScript: sKilledZircon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chandelier of Feature
	(properties
		x 105
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(chick setScript: sKilledChick)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dontShoot of Feature
	(properties
		x 105
		y 190
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gCurRoom setScript: sFreddyShotsAcesWrong)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gunSound of FPSound
	(properties
		flags 1
	)
)

(instance chandSound of FPSound
	(properties
		flags 1
		number 2806
	)
)

(instance deadSound of FPSound
	(properties
		flags 1
	)
)

(instance diveSound of FPSound
	(properties
		flags 1
	)
)

