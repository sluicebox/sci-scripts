;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use StopWalk)
(use DPath)
(use Sound)
(use Motion)
(use Actor)

(public
	theStupor 0
	dancer 1
	spinDown 2
	day2Script 3
)

(local
	local0
	local1
	local2
	[local3 5] = [1140 0 1 1 0]
)

(instance thisCover of View
	(properties
		x 237
		y 67
		view 140
		loop 4
		priority 4
		signal 16
	)
)

(instance theEmerald of View
	(properties
		x 210
		y 124
		view 216
		loop 2
		priority 4
		signal 17
	)
)

(instance flashGreen of Prop
	(properties
		x 165
		y 153
		view 140
		loop 2
	)
)

(instance marian of Actor
	(properties
		x 87
		y 166
		view 220
	)
)

(instance theStupor of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSCRIPT 964)
				(= local0 gTheCursor)
				(HandsOff)
				(ScriptID 19) ; John
				(thisCover init: stopUpd:)
				(gCurRoom north: 0)
				((ScriptID 19) ; John
					loop: 1
					posn: 164 108
					setCycle: StopWalk 152
					init:
				)
				(= ticks 12)
			)
			(1
				(Converse 1 @local3 13 0 self) ; "Tsk, for shame, Robin. Already deep in drunken slumber."
			)
			(2
				((ScriptID 19) setMotion: MoveTo 214 104 self) ; John
			)
			(3
				((ScriptID 19) setMotion: MoveTo 229 83 self) ; John
			)
			(4
				(= notKilled 1)
				(gTheIconBar disable:)
				(gGame setCursor: 5 1 180 125)
				(gCast eachElementDo: #hide)
				(DoSound sndGLOBAL_REVERB 0)
				(gRgnMusic fade: 0 30 8 1)
				(DrawPic 803 8 1 0)
				(= ticks 120)
			)
			(5
				((ScriptID 19) dispose:) ; John
				(thisCover dispose:)
				(Display 141 0 dsCOORD 35 40 dsCOLOR global185) ; "Cast adrift....floating....a song....a song upon"
				(Display 141 1 dsCOORD 50 55 dsCOLOR global185) ; "the wind....wind that rustles through"
				(Display 141 2 dsCOORD 35 70 dsCOLOR global185) ; "leaves....calling me onward....into a heart of"
				(Display 141 3 dsCOORD 130 85 dsCOLOR global185) ; "green...."
				(= seconds 10)
			)
			(6
				(= notKilled 1)
				(DrawPic 210 8 1 0)
				(marian cycleSpeed: 12 init:)
				(self setScript: dancer self)
				(= ticks 160)
			)
			(7
				(Display 141 4 dsCOORD 50 10 dsCOLOR global185) ; "A woman...as graceful as the willows which"
				(Display 141 5 dsCOORD 40 25 dsCOLOR global185) ; "surround her....swaying to the music in the wind...."
			)
			(8
				(DrawPic 803 8 1 0)
				(gEgo hide:)
				(= ticks 80)
			)
			(9
				(DoSound sndGLOBAL_REVERB 20)
				(gRgnMusic number: 141 loop: -1 vol: 127 play:)
				(DrawPic 140 8 1 0)
				(gEgo view: 142 loop: 0 cel: 0 posn: 89 92)
				(gCast eachElementDo: #show)
				(gCurRoom north: 150)
				(gEgo get: 2) ; halfHeart
				(= ticks 80)
			)
			(10
				(gEgo setCycle: CT 2 1 self)
			)
			(11
				(gEgo setScript: day2Script)
			)
		)
	)
)

(instance dancer of TScript
	(properties)

	(method (dispose)
		(gRgnMusic fade: 0 20 12 1)
		(DisposeScript 964)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic number: 211 loop: -1 vol: 127 play:)
				(++ local1)
				(= cycles 15)
			)
			(1
				(marian loop: 0 cel: 0 posn: 87 166 setCycle: End self)
			)
			(2
				(marian loop: 2 cel: 0 posn: 100 166 setCycle: CT 10 1 self)
			)
			(3
				(marian
					view: 213
					setLoop: 3
					cel: 3
					posn: 105 167
					setStep: 1 1
					cycleSpeed: 6
					setCycle: Fwd
				)
				(= ticks 30)
			)
			(4
				(marian
					cycleSpeed: 6
					setCycle: Walk
					setMotion:
						DPath
						87
						163
						96
						160
						107
						156
						120
						154
						138
						148
						146
						150
						161
						152
						172
						155
						182
						163
						177
						171
						164
						176
						152
						180
						140
						178
						135
						172
						144
						161
						148
						157
						self
				)
			)
			(5
				(marian setCycle: CT 1 1 self)
			)
			(6
				(marian
					loop: 0
					cel: 2
					posn: 151 156
					cycleSpeed: 12
					setStep: 3 2
					setCycle: Walk
					setMotion: MoveTo 150 155 self
				)
			)
			(7
				(marian view: 220 loop: 1 cel: 0 x: 153 y: 151)
				(self cue:)
			)
			(8
				(marian setLoop: 1 posn: 153 152 setCel: 0 setCycle: End self)
			)
			(9
				(marian view: 220 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(10
				(marian view: 213 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(11
				(marian view: 213 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(12
				(marian setLoop: 2 setCel: 0 setCycle: End self)
			)
			(13
				(= notKilled 1)
				(marian view: 220 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(14
				(NormalEgo)
				(gEgo
					view: 0
					cycleSpeed: 6
					moveSpeed: 6
					posn: 172 230
					show:
					setMotion: MoveTo 172 189 self
				)
			)
			(15
				(marian setCycle: Beg self)
			)
			(16
				(DrawPic 210 100 1 0)
				(gRgnMusic fade: 80 20 12 0)
				(marian view: 220 setLoop: 7 setCel: 0 setCycle: End self)
				(vanishSound play:)
			)
			(17
				(marian hide:)
				(flashGreen init: setCycle: Fwd)
				(gEgo
					setMotion: MoveTo (+ (marian x:) 20) (+ (marian y:) 10) self
				)
			)
			(18
				(magicSound play:)
				(marian dispose:)
				(gEgo loop: 7)
				(= ticks 6)
			)
			(19
				(= notKilled 1)
				(Say 1140 2 self) ; "She's gone, but there's something here. A glittering green stone where she stood."
			)
			(20
				(flashGreen setCycle: 0 dispose:)
				(gEgo view: 7 loop: 0 setCycle: End self)
				(gEgo get: 2) ; halfHeart
			)
			(21
				(= notKilled 1)
				(Say 1140 3 self) ; "The willows....I hear them whisper her name....Marian....Marian...."
			)
			(22
				(Say 1140 4 self) ; "Come back, Marian.....come back to me...."
			)
			(23
				(self dispose:)
			)
		)
	)
)

(instance spinDown of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(marian setLoop: 9 setCel: 6)
				(= cycles 1)
			)
			(1
				(marian setLoop: 9 setCel: 1)
				(= cycles 1)
			)
			(2
				(marian setLoop: 11 setCel: 0)
				(= cycles 1)
			)
			(3
				(marian setCel: 1)
				(= cycles 1)
			)
			(4
				(marian setCel: 2)
				(= cycles 1)
			)
			(5
				(marian setCel: 3)
				(= cycles 1)
			)
			(6
				(marian setCel: 4)
				(= cycles 1)
			)
			(7
				(marian setCel: 5)
				(= cycles 1)
			)
			(8
				(marian setCel: 6)
				(= cycles 1)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance day2Script of TScript
	(properties)

	(method (dispose)
		(magicSound dispose:)
		(vanishSound dispose:)
		(gGame setCursor: 0 1)
		(super dispose: &rest)
		(DisposeScript 141)
	)

	(method (doit)
		(super doit:)
		(if (and (== global202 256) local2)
			(Palette palANIMATE 224 254 local2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1140 5 self) ; "How my head aches! By the Blessed Lady, I swear I'll never seek to drown my melancholy in a cup again!"
			)
			(1
				(Say 1140 6 self) ; "Uhh, my poor back. I must speak to Little John about leaving me to lie on my quiver all night!"
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(Say 1140 7 self) ; "But that dream...that woman..."
			)
			(4
				(gEgo setLoop: 1 setCel: 1)
				(= ticks 20)
			)
			(5
				(Say 1140 8 self) ; "And what is this, clenched in my own hand--?"
			)
			(6
				(= local2 -2)
				(gEgo hide:)
				((ScriptID 140 1) hide:) ; fire
				((ScriptID 140 2) hide:) ; ledge
				((ScriptID 140 3) hide:) ; peg
				(= notKilled 1)
				(DrawPic 215 8 1 0)
				(theEmerald init:)
				(magicSound number: 13 play:)
				(= seconds 5)
			)
			(7
				(= local2 0)
				(Say 1140 9 self) ; "The emerald! Now I can see its shape, half a heart. Maybe I still dream....."
			)
			(8
				((ScriptID 140 1) show:) ; fire
				(gEgo show:)
				((ScriptID 140 2) show:) ; ledge
				((ScriptID 140 3) show:) ; peg
				(theEmerald dispose:)
				(DrawPic 140 8 1 0)
				(magicSound stop: dispose:)
				(= cycles 1)
			)
			(9
				(gEgo setLoop: 1 setCel: 0)
				(= ticks 20)
			)
			(10
				(Say 1140 10 self) ; "Nay, not with this pounding in my head. I must be well and truly awake."
			)
			(11
				(gEgo view: 7 setLoop: 2 setCel: 2 posn: 92 101)
				(= ticks 6)
			)
			(12
				(gEgo setCel: 1)
				(= ticks 6)
			)
			(13
				(NormalEgo)
				(Say 1140 11 self) ; "Somehow I must find this Marian and learn the meaning of the emerald."
			)
			(14
				(Say 1140 12 self) ; "Aye, and see if she is as beautiful as I dreamed."
			)
			(15
				(HandsOn)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance vanishSound of Sound
	(properties
		flags 1
		number 213
	)
)

(instance magicSound of Sound
	(properties
		flags 1
		number 216
	)
)

