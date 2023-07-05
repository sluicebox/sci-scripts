;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm720 0
	droppedThemTimer 1
)

(instance rm720 of FPRoom
	(properties
		noun 23
		picture 720
		horizon 0
		north 730
		south 260
	)

	(method (notify)
		(gCurRoom setScript: sFreddyDropsGuns)
	)

	(method (init)
		(gEgo
			init:
			x: 340
			y: 150
			normalize:
			setHeading: 0
			setSpeed: 7
			scaleSignal: 1
			scaleX: 98
			scaleY: 98
		)
		(gGameMusic1 number: 721 flags: 1 loop: -1 play:)
		(super init:)
		(gGame handsOff:)
		(penelope init: setScale: Scaler 97 75 172 143)
		(bigMap init:)
		(bookshelf init:)
		(bucket init:)
		(closedWindow init:)
		(kidPix init:)
		(openWindow init:)
		(smallMap init:)
		(washington init:)
		(sword1 init: stopUpd:)
		(sword2 init: stopUpd:)
		(schoolbook init: stopUpd:)
		(schoolbook2 init: stopUpd:)
		(box init: stopUpd:)
		(slate init: stopUpd:)
		(basementDoor init: stopUpd:)
		(bench init: setOnMeCheck: 1 2)
		(bigDesk init: setOnMeCheck: 1 4)
		(blackBoard init: setOnMeCheck: 1 8)
		(book1 init: setOnMeCheck: 1 16)
		(book2 init: setOnMeCheck: 1 32)
		(book3 init: setOnMeCheck: 1 64)
		(broom init: setOnMeCheck: 1 128)
		(coatrack init: setOnMeCheck: 1 256)
		(desks init: setOnMeCheck: 1 512)
		(flag init: setOnMeCheck: 1 1024)
		(globe init: setOnMeCheck: 1 2048)
		(lamp init: setOnMeCheck: 1 4096)
		(paintbrushes init: setOnMeCheck: 1 8192)
		(stove init: setOnMeCheck: 1 16384)
		(smallPix init: setOnMeCheck: 1 2)
		(smallPix2 init: setOnMeCheck: 1 2)
		(smallPix3 init: setOnMeCheck: 1 2)
		(woodCarrier init: setOnMeCheck: 1 4)
		(self setScript: sEndGame)
	)
)

(instance sFreddyDropsGuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gGame handsOff:)
				(gTimers delete: droppedThemTimer)
				(LoadMany rsSOUND 2748)
				(= cycles 1)
			)
			(2
				(gEgo
					view: 724
					setLoop: 0
					setCel: 0
					setScale: 0
					put: 44 ; Pistols
					setCycle: End self
				)
			)
			(3
				(localSound number: 2748 play: self)
			)
			(4
				(= cycles 10)
			)
			(5
				(gMessager say: 20 4 5 0 self) ; "You resignedly unbuckle your holsters, letting your guns slip to the floor. Penelope appears to relax a little, but her finger is still on the trigger of the Derringer. Looks like she might shoot at any moment!"
			)
			(6
				(getSlateTimer setReal: getSlateTimer 10)
				(gUser canControl: 0)
				(gTheIconBar disable: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEndGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 741 2101)
				(penelope view: 726 loop: 0 cel: 0 setSpeed: 10 setCycle: Fwd)
				(gEgo setMotion: MoveTo 270 167 self)
			)
			(1
				(UnLoad 128 842)
				(gEgo view: 728 loop: 1 cel: 0 scaleSignal: 0 stopUpd:)
				(= cycles 3)
			)
			(2
				((ScriptID 1814 57) ; Willy
					x: 190
					y: 5
					textX: -165
					textY: 120
					talkWidth: 265
					modeless: 1
				)
				(gMessager say: 17 0 0 1 self) ; "When Freddy stepped inside, Penelope wuz standin' at the desk, packin' in a hurry. She didn't even notice him come in. Gazin' at her like that, Freddy saw her fer the conniving snake-in-the-grass she really wuz."
			)
			(3
				(penelope
					view: 802
					setCycle: StopWalk -1
					setSpeed: 7
					setHeading: 135
				)
				(UnLoad 128 726)
				(= cycles 50)
			)
			(4
				(gMessager say: 17 0 0 2 7 self) ; "HEY, PENELOPE! What gives??"
			)
			(5
				(penelope setMotion: MoveTo 66 112 self)
			)
			(6
				(penelope setMotion: MoveTo 132 120 self)
			)
			(7
				((ScriptID 1814 57) textY: 140) ; Willy
				(gMessager say: 17 0 0 8 9 self) ; "Penelope slowly moved her hands up to her bodice... and began to carefully unbutton it... one button at a time... staring straight into Freddy's eyes..."
				(penelope view: 721 loop: 0 cel: 0 setCycle: End self)
				(UnLoad 128 802)
			)
			(8)
			(9
				(gMessager say: 17 0 0 10 12 self) ; "She slowly slipped her hands under the fabric."
				(penelope
					view: 721
					loop: 1
					cel: 0
					setSpeed: 10
					setCycle: CT 2 1 self
				)
				(UnLoad 128 802)
			)
			(10)
			(11
				(gMessager say: 17 0 0 13 15 self) ; "And before Freddy knew it, Penelope yanked a Derringer from her bosom and aimed it at him!"
				(pennySound number: 741 play:)
				(penelope view: 721 loop: 1 cel: 3 setCycle: End self)
			)
			(12)
			(13
				(droppedThemTimer setReal: droppedThemTimer 10)
				((ScriptID 1814 57) modeless: 0) ; Willy
				(gUser canControl: 0)
				(penelope stopUpd:)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyAndSlate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 2101 2760 2743)
				(gGame points: 10 0 self)
			)
			(1
				(gEgo
					view: 725
					setLoop: 0
					setCel: 0
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(slate dispose:)
				(gMessager say: 18 0 0 1 self) ; "You grab the slate, and whip it around just in the nick of time!"
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo view: 725 setLoop: 1 setCel: 0)
				(= cycles 30)
			)
			(5
				(pennySound number: 2101 play:)
				(penelope view: 722 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(freddySound number: 2760 play:)
				(gEgo view: 725 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(7
				(LoadMany rsSOUND 2101)
				(= ticks 30)
			)
			(8
				(gEgo view: 728 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(9
				(gMessager say: 18 0 0 2 self) ; "As you bend down to pick up your gunbelt, Penelope hurls the Derringer straight at your head!"
			)
			(10
				(penelope view: 722 loop: 1 cel: 0 setCycle: End self)
			)
			(11
				(pistol
					init:
					setScale: Scaler 97 75 172 143
					setLoop: 6
					setStep: 25 10
					setCycle: Fwd
					setMotion: MoveTo 256 133 self
				)
			)
			(12
				(pistol dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 780)
				(gGameMusic1 stop:)
				(freddySound number: 2761 play: self)
			)
			(13
				(++ gCurPuzzle)
				(gUser canControl: 0)
				(gGame handsOn:)
				(gCurRoom newRoom: 730)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 2101 2761)
				(gGame handsOff:)
				(if register
					(gEgo
						view: 723
						setLoop: 0
						setCel: 0
						setScale: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(penelope view: 722 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(pennySound number: 2101 play:)
				(penelope setCycle: Beg)
				(gEgo
					view: 724
					setLoop: 1
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(= global122 6)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance pistol of Actor
	(properties
		x 180
		y 71
		view 720
		loop 5
	)
)

(instance penelope of Actor
	(properties
		x 29
		y 122
		noun 14
		view 726
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gCurRoom setScript: sFreddyDies 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance basementDoor of View
	(properties
		x 107
		y 100
		view 720
		loop 3
		signal 16384
	)
)

(instance sword1 of Prop
	(properties
		x 42
		y 64
		noun 21
		view 720
		priority 7
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 97 75 172 143)
	)
)

(instance sword2 of Prop
	(properties
		x 50
		y 64
		noun 21
		view 720
		cel 1
		priority 7
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 97 75 172 143)
	)
)

(instance box of View
	(properties
		x 40
		y 100
		view 720
		loop 4
		priority 10
		signal 16400
	)
)

(instance schoolbook of View
	(properties
		x 168
		y 172
		noun 22
		view 720
		loop 4
		cel 3
		priority 10
		signal 16400
	)
)

(instance schoolbook2 of View
	(properties
		x 23
		y 104
		noun 22
		view 720
		loop 4
		cel 5
		priority 10
		signal 16400
	)
)

(instance pistols of View ; UNUSED
	(properties
		x 221
		y 137
		view 720
		loop 5
	)
)

(instance slate of View
	(properties
		x 249
		y 150
		noun 15
		view 720
		loop 2
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gCurRoom timer:) getSlateTimer)
					(gCurRoom timer: 0)
					(gTimers delete: getSlateTimer)
					(gCurRoom setScript: sFreddyAndSlate)
				else
					(gMessager say: noun theVerb 1) ; "When I say "Drop 'em," I mean "Drop 'em!""
					(gCurRoom setScript: sFreddyDies)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bench of Feature
	(properties
		x 296
		y 124
		noun 42
		nsTop 114
		nsLeft 274
		nsBottom 134
		nsRight 319
	)
)

(instance bigDesk of Feature
	(properties
		x 45
		y 111
		noun 45
	)
)

(instance blackBoard of Feature
	(properties
		x 46
		y 81
		noun 29
	)
)

(instance book1 of Feature
	(properties
		x 49
		y 172
		noun 24
	)
)

(instance book2 of Feature
	(properties
		x 154
		y 180
		noun 25
	)
)

(instance book3 of Feature
	(properties
		x 176
		y 187
		noun 47
	)
)

(instance broom of Feature
	(properties
		x 197
		y 98
		noun 41
	)
)

(instance coatrack of Feature
	(properties
		x 310
		y 85
		noun 43
	)
)

(instance desks of Feature
	(properties
		x 223
		y 149
		noun 32
	)
)

(instance flag of Feature
	(properties
		x 8
		y 70
		noun 28
	)
)

(instance globe of Feature
	(properties
		x 99
		y 171
		noun 46
	)
)

(instance lamp of Feature
	(properties
		x 80
		y 26
		noun 31
	)
)

(instance paintbrushes of Feature
	(properties
		x 16
		y 162
		noun 27
	)
)

(instance stove of Feature
	(properties
		x 235
		y 84
		noun 35
	)
)

(instance bigMap of Feature
	(properties
		x 151
		y 77
		noun 38
		nsTop 60
		nsLeft 141
		nsBottom 94
		nsRight 161
	)
)

(instance bookshelf of Feature
	(properties
		x 171
		y 50
		noun 48
		nsTop 45
		nsLeft 132
		nsBottom 55
		nsRight 211
	)
)

(instance bucket of Feature
	(properties
		x 212
		y 111
		noun 37
		nsTop 103
		nsLeft 207
		nsBottom 119
		nsRight 217
	)
)

(instance closedWindow of Feature
	(properties
		x 182
		y 77
		noun 33
		nsTop 56
		nsLeft 171
		nsBottom 98
		nsRight 194
	)
)

(instance kidPix of Feature
	(properties
		x 208
		y 80
		noun 40
		nsTop 63
		nsLeft 200
		nsBottom 97
		nsRight 216
	)
)

(instance openWindow of Feature
	(properties
		x 284
		y 80
		noun 34
		nsTop 54
		nsLeft 269
		nsBottom 106
		nsRight 299
	)
)

(instance smallMap of Feature
	(properties
		x 130
		y 76
		noun 39
		nsTop 64
		nsLeft 123
		nsBottom 88
		nsRight 138
	)
)

(instance washington of Feature
	(properties
		x 33
		y 44
		noun 30
		nsTop 33
		nsLeft 37
		nsBottom 55
		nsRight 55
	)
)

(instance woodCarrier of Feature
	(properties
		x 251
		y 123
		noun 36
		nsTop 116
		nsLeft 245
		nsBottom 130
		nsRight 257
	)
)

(instance smallPix of Feature
	(properties
		x 99
		y 48
		noun 44
	)
)

(instance smallPix2 of Feature
	(properties
		x 257
		y 80
		noun 44
	)
)

(instance smallPix3 of Feature
	(properties
		x 250
		y 68
		noun 44
	)
)

(instance derringerTimer of Timer
	(properties)

	(method (setReal)
		(gCurRoom timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(gCurRoom setScript: sFreddyDies 1)
	)
)

(instance droppedThemTimer of Timer
	(properties)

	(method (setReal)
		(derringerTimer dispose: delete:)
		(gCurRoom timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(gMessager say: 50 0 0) ; "Ignoring Penelope turns out to be a bad idea. She decides you have inadequate ventilation."
		(gCurRoom setScript: sFreddyDies)
	)
)

(instance getSlateTimer of Timer
	(properties)

	(method (setReal)
		(derringerTimer dispose: delete:)
		(gCurRoom timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(gMessager say: 49 0 0) ; "You fool, you've deliberately tried to ruin all my plans. I just wanted you to know I don't regret what I'm about to do. Say Hi-yo, Silver!"
		(gCurRoom setScript: sFreddyDies)
	)
)

(instance freddySound of FPSound
	(properties
		flags 1
	)
)

(instance pennySound of FPSound
	(properties
		flags 1
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

