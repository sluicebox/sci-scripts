;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1040)
(include sci.sh)
(use Main)
(use AnimDialog)
(use SpeakWindow)
(use Talker)
(use Scaler)
(use Osc)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1040 0
	tkrRoger 5
	tkrFlo 13
)

(instance rm1040 of Rm
	(properties
		picture 128
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 688 696 697 687 0)
		(NormalEgo 0)
		(switch gPrevRoomNum
			(1020
				(gCurRoom setScript: sRogCaught)
			)
			(1045
				(gCurRoom setScript: sFollowWD40)
			)
			(1050
				(gCurRoom setScript: sBlobOutside)
			)
			(else
				(gCurRoom setScript: sGetAway)
			)
		)
		(super init:)
		(gSq5Music2 number: 654 setLoop: -1 play:)
	)
)

(instance sGetAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rogHead x: 3 y: 63 init:)
				(droole init: setCycle: Osc)
				(flo init: setCycle: Osc)
				(= seconds 3)
			)
			(1
				(if (IsFlag 84)
					(gMessager say: 7 0 0 0 self) ; "Droole, get us out of here! Flo, call StarCon and tell them what happened."
				else
					(++ state)
					(= cycles 1)
				)
			)
			(2
				(gCurRoom newRoom: 1060)
				(self dispose:)
			)
			(3
				(gMessager say: 2 0 0 0 self) ; "Captain, the Eureka has broken up. The Blob is attacking US now..."
			)
			(4
				(blob
					view: 697
					loop: 2
					cel: 0
					x: 280
					y: 71
					init:
					setCycle: CT 7 1 self
				)
				(exAct1
					view: 697
					loop: 1
					cel: 0
					x: 199
					y: 72
					init:
					setCycle: CT 7
				)
			)
			(5
				(blob setCycle: End self)
				(exAct1 setCycle: End)
				(ooze3 init: setCycle: End)
			)
			(6
				(ShakeScreen 5 ssLEFTRIGHT)
				(= seconds 2)
			)
			(7
				(PalVary pvINIT 2100 1)
				(= seconds 2)
			)
			(8
				(EgoDead 44) ; "You were bested by a giant ball of phlegm. Whatta way to go."
			)
		)
	)
)

(instance sRogCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pukoid1 init:)
				(pukoid2 init:)
				(pukoid3 init:)
				(pukoid4 init:)
				(pukoid5 init:)
				(pukoid6 init:)
				(pukoid7 init:)
				(quirk init:)
				(quirkArm init:)
				(quirkPuke init:)
				(= seconds 2)
			)
			(1
				(pukoid1 setCycle: End self)
			)
			(2
				(pukoid1 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(3
				(quirkPuke setCycle: End)
				(gEgo
					view: 0
					setLoop: -1
					setLoop: 8
					setScale: 0
					cel: 2
					x: 176
					y: 148
					setCycle: 0
					init:
				)
				(pukoid1 setCycle: End self)
			)
			(4
				(gMessager say: 8 0 0 1 self) ; "Welcome aboard, Captain Wilco. A pity you can't stay, but I'm afraid you won't be with us very much longer..."
			)
			(5
				(gMessager say: 8 0 0 2 self) ; "I won't go down with out a fight, Quirk! I know Kung Fu, Karate, Tae Kwon Do, Judo, and several other Chinese Words!"
			)
			(6
				(quirk setCel: 1)
				(quirkArm loop: 2 x: 140 y: 162)
				(quirkPuke loop: 1 cel: 0 x: 171 y: 158 setCycle: End self)
			)
			(7
				(gMessager say: 8 0 0 3 self) ; "There's no escape for you this time, young broom jockey. Your fate is sealed."
			)
			(8
				(gMessager say: 8 0 0 4 self) ; "Not this time Quirk, now the foot's in the other shoe! You're toast!"
			)
			(9
				(if (not (IsFlag 234))
					(gMessager say: 9 0 0 0 self) ; "You're the one who's toast this time, Roger. Forgetting that that little item of vital importance back on Genetix has come back to haunt you. We hate to say we told you so, but we did."
				else
					(gSq5Music2 number: 260 setLoop: 1 play:)
					(wd40 init: setCycle: End self)
				)
			)
			(10
				(if (not (IsFlag 234))
					(EgoDead 49) ; "It's a nice look for you Roger, too bad it can't last."
				else
					(gSq5Music1 number: 35 setLoop: -1 play:)
					(pukoid1 loop: 2 cel: 0 setCycle: CT 2 1)
					(pukoid2 setCycle: CT 2 1)
					(pukoid3 setCycle: CT 2 1)
					(pukoid4 setCycle: CT 2 1)
					(pukoid5 setCycle: CT 2 1)
					(pukoid6 setCycle: CT 2 1)
					(pukoid7 setCycle: CT 2 1)
					(gEgo
						view: 688
						setLoop: -1
						setLoop: 3
						setCycle: End self
					)
				)
			)
			(11
				(gCurRoom newRoom: 1045)
			)
		)
	)
)

(instance sBlobOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(blob init: setCycle: Osc)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(= seconds 2)
			)
			(2
				(gSq5Music2 number: 654 setLoop: -1 play:)
				(gEgo init: hide:)
				(rogHead
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 4
					setMotion: MoveTo 3 63 self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(gSq5Music1 number: 241 setLoop: 1 play:)
				(= cycles 1)
			)
			(5
				(gSq5Music1 number: 241 setLoop: 1 play:)
				(gMessager say: 1 0 0 1 self) ; "BEEP BEEP"
			)
			(6
				(gSq5Music1 number: 241 setLoop: 1 play:)
				(= cycles 1)
			)
			(7
				(gSq5Music1 number: 241 setLoop: 1 play:)
				(gMessager say: 1 0 0 2 self) ; "|f3| BEEP! BEEP!"
			)
			(8
				(gMessager say: 4 0 0 0 self) ; "This is Captain Wilco. Go ahead Eureka."
			)
			(9
				(shuttle
					init:
					setLoop: 1
					setCycle: 0
					setScale: Scaler 100 48 120 99
					setMotion: MoveTo 189 109 self
				)
			)
			(10
				(gMessager say: 3 0 0 1 self) ; "I see it, Flo. Looks like Quirk's trying to make a run for it..."
			)
			(11
				(shuttle setMotion: MoveTo 205 102 self)
			)
			(12
				(gMessager say: 3 0 0 2 self) ; "Holy hockey-pucks! He's heading straight for the blob!"
			)
			(13
				(shuttle setMotion: MoveTo 211 99 self)
			)
			(14
				(exAct1 init: setCycle: End self)
			)
			(15
				(shuttle dispose:)
				(blob loop: 3 cel: 0 x: 220 y: 97 setCycle: Osc 3 self)
			)
			(16
				(exAct1
					view: 696
					loop: 4
					cel: 0
					x: 225
					y: 87
					setCycle: End self
				)
			)
			(17
				(gMessager say: 3 0 0 3 self) ; "Uh-oh. This looks bad, very bad. I think we're in trouble."
			)
			(18
				(tkrFlo normal: 0 keepWindow: 1 textY: 85)
				(= cycles 1)
			)
			(19
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 999)
				(gMessager say: 5 0 1 0 self) ; "Is there anything I can do Captain?"
			)
			(20
				(gGame handsOff:)
				(tkrFlo normal: 1 textY: 10)
				(if (tkrFlo whichSelect:)
					(switch (tkrFlo whichSelect:)
						(1
							(gMessager say: 5 0 2 0 self) ; "Cliffy says he's locked on to you and standing by..."
						)
						(2
							(gMessager say: 5 0 3 0 self) ; "Alright Captain, good luck! Eureka out."
						)
						(3
							(gMessager say: 5 0 4 0 self) ; "As you wish Captain. Eureka out."
						)
					)
				)
			)
			(21
				(exAct1 setCycle: Beg self)
			)
			(22
				(exAct1 hide:)
				(if (== (tkrFlo whichSelect:) 1)
					(SetScore 250 20)
					(gCurRoom newRoom: 240)
				else
					(blob setMotion: MoveTo 225 49 self)
				)
			)
			(23
				(gSq5Music2 number: 250 setLoop: 1 play:)
				(ShakeScreen 5 ssLEFTRIGHT)
				(= seconds 2)
			)
			(24
				(blob
					view: 697
					loop: 2
					cel: 0
					x: 280
					y: 71
					setCycle: CT 7 1 self
				)
				(exAct1
					view: 697
					loop: 1
					cel: 0
					x: 199
					y: 72
					show:
					setCycle: CT 7
				)
			)
			(25
				(blob setCycle: End self)
				(exAct1 setCycle: End)
				(ooze3 init: setCycle: End)
			)
			(26
				(PalVary pvINIT 2100 1)
				(= seconds 4)
			)
			(27
				(if (== (tkrFlo whichSelect:) 2)
					(EgoDead 35) ; "Some space hero you are. Sheesh."
				else
					(EgoDead 39) ; "A defeatist attitude won't get you anything--except a body bag."
				)
			)
		)
	)
)

(instance sFollowWD40 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (< (wd40 x:) 50) (== (gEgo mover:) 0) (== state 3))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 688
					cel: 0
					x: 176
					y: 148
					setLoop: -1
					setLoop: 4
					init:
					setCycle: End self
				)
				(wd40 view: 688 loop: 1 cel: 0 x: 151 y: 147 init:)
				(wd40head init: setCycle: Fwd)
				(pukoid1 loop: 2 setCel: (pukoid1 lastCel:) init:)
				(pukoid2 setCel: (pukoid2 lastCel:) init:)
				(pukoid3 setCel: (pukoid3 lastCel:) init:)
				(pukoid4 setCel: (pukoid4 lastCel:) init:)
				(pukoid5 setCel: (pukoid5 lastCel:) init:)
				(pukoid6 setCel: (pukoid6 lastCel:) init:)
				(pukoid7 setCel: (pukoid7 lastCel:) init:)
				(cloud1 init: setCycle: Fwd)
				(cloud2 init: setCycle: Fwd)
				(cloud3 init: setCycle: Fwd)
				(quirk cel: 1 init:)
				(quirkArm loop: 2 x: 140 y: 162 init:)
			)
			(1
				(gMessager say: 6 0 0 0 self) ; "I've temporarily frozen them with my new liquid Nitrogen blasters. We must quickly make our way to the transporter room where Cliffy awaits."
			)
			(2
				(wd40 loop: 6 cel: 0 setCycle: End self)
				(wd40head dispose:)
				(gEgo setLoop: -1 setLoop: 7 cel: 0 setCycle: End)
				(gSq5Music1 fade: 0 10 10 1)
				(gSq5Music2 fade: 0 10 10 1)
			)
			(3
				(gCurRoom newRoom: 1050)
				(self dispose:)
			)
		)
	)
)

(instance quirkPuke of Prop
	(properties
		x 158
		y 157
		view 686
		loop 3
		signal 16384
	)
)

(instance wd40 of Actor
	(properties
		x 151
		y 147
		view 688
		signal 16384
	)
)

(instance pukoid1 of Actor
	(properties
		x 198
		y 148
		view 687
		signal 16384
	)
)

(instance pukoid2 of Actor
	(properties
		x 268
		y 175
		view 687
		loop 3
	)
)

(instance pukoid3 of Actor
	(properties
		x 67
		y 157
		view 687
		loop 7
	)
)

(instance pukoid4 of Actor
	(properties
		x 263
		y 132
		view 687
		loop 4
	)
)

(instance pukoid5 of Actor
	(properties
		x 157
		y 122
		view 687
		loop 5
		priority 1
		signal 16
	)
)

(instance pukoid6 of Actor
	(properties
		x 302
		y 147
		view 687
		loop 6
	)
)

(instance pukoid7 of Actor
	(properties
		x 98
		y 141
		view 687
		loop 8
	)
)

(instance blob of Actor
	(properties
		x 228
		y 89
		view 696
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (self view:) 696) (self mover:))
			(self scaleX: (+ (* (- 89 (self y:)) 2) 128))
			(self scaleY: (+ (* (- 89 (self y:)) 2) 128))
			(self scaleSignal: 1)
		)
	)
)

(instance shuttle of Actor
	(properties
		x 166
		y 120
		view 696
		loop 1
		priority 1
		signal 16400
	)
)

(instance exAct1 of Actor
	(properties
		x 213
		y 98
		view 696
		loop 2
		priority 4
		signal 16400
	)
)

(instance ooze3 of Prop
	(properties
		x 94
		y 69
		view 697
	)
)

(instance flo of Prop
	(properties
		x 145
		y 102
		view 697
		loop 5
		priority 5
		signal 16400
	)
)

(instance droole of Prop
	(properties
		x 193
		y 104
		view 697
		loop 6
		priority 5
		signal 16400
	)
)

(instance wd40head of Prop
	(properties
		x 149
		y 106
		view 688
		loop 2
		priority 15
		signal 16400
	)
)

(instance cloud1 of Prop
	(properties
		x 242
		y 163
		view 689
		priority 14
		signal 16400
	)
)

(instance cloud2 of Prop
	(properties
		x 25
		y 144
		view 689
		loop 1
		priority 14
		signal 16400
	)
)

(instance cloud3 of Prop
	(properties
		x 190
		y 133
		view 689
		loop 2
		priority 14
		signal 16400
	)
)

(instance tkrFlo of ChoiceTalker
	(properties
		x 175
		y 1
		view 1008
		talkWidth 85
		textX -110
		textY 10
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(if normal
			(self talkWidth: 85)
		else
			(self talkWidth: 200)
		)
		(super init: floBust floEyes floMouth &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance floBust of Prop
	(properties
		view 1008
	)
)

(instance floEyes of Prop
	(properties
		nsTop 33
		nsLeft 39
		view 1008
		loop 2
		signal 16384
	)
)

(instance floMouth of Prop
	(properties
		nsTop 43
		nsLeft 45
		view 1008
		loop 1
		signal 16384
	)
)

(instance tkrRoger of Talker
	(properties
		y 56
		view 697
		loop 4
		talkWidth 150
		textX 10
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow SpeakWindow)
		(gSystemWindow tailX: 80 tailY: 160 xOffset: 65)
		(super init: rogBust rogEyes rogMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance rogBust of Prop
	(properties
		view 697
		loop 4
	)
)

(instance rogEyes of Prop
	(properties
		nsTop 46
		nsLeft 33
		view 697
		loop 8
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 68
		nsLeft 2
		view 697
		loop 7
	)
)

(instance quirk of Actor
	(properties
		x 132
		y 120
		view 686
		loop 4
		priority 8
		signal 16400
	)
)

(instance quirkArm of Actor
	(properties
		x 133
		y 162
		view 686
		signal 16384
	)
)

(instance rogHead of Actor
	(properties
		x -50
		y 63
		view 697
		loop 4
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Communicator
				(gCurRoom newRoom: 240)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

