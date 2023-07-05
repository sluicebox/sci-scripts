;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use RTEyeCycle)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	jment 0
)

(local
	[local0 9] = [43 0 2 4 25 37 21 25 28]
	[local9 9] = [44 0 2 4 27 37 21 25 20]
	[local18 9] = [58 0 2 4 22 36 22 26 26]
	[local27 9] = [59 0 2 4 21 32 20 23 31]
	[local36 9] = [131 0 2 4 24 38 23 27 14]
	[local45 9] = [133 3 2 4 24 37 20 24 16]
	[local54 9] = [135 0 2 4 14 37 14 26 15]
	[local63 9] = [253 0 2 4 21 37 19 27 10]
	[local72 9] = [431 0 2 4 21 32 23 25 25]
	[local81 9] = [673 0 2 4 18 33 21 20 21]
	[local90 9] = [-1 {Poacher} 27 0 0 0 0 0 0]
	[local99 9] = [-1 {Peasant Woman} 6 0 0 0 0 0 0]
	[local108 7] = [1420 0 1 1 1 1 0]
	[local115 12] = [1420 4 2 2 2 2 1 1 1 1 1 0]
	[local127 13] = [1420 13 1 1 2 2 2 3 3 1 4 4 0]
	[local140 4] = [1420 23 1 0]
	[local144 11] = [1420 24 1 2 2 2 3 3 3 4 0]
	[local155 6] = [1420 32 1 2 3 0]
	[local161 4] = [1420 35 1 0]
	[local165 6] = [1420 36 1 2 3 0]
	[local171 7] = [1420 39 1 1 2 3 0]
	[local178 5] = [1420 43 1 2 0]
	[local183 12] = [1420 45 1 2 2 2 3 3 3 4 3 0]
	[local195 5] = [1420 54 1 1 0]
	[local200 5] = [1420 56 1 1 0]
	[local205 5] = [1420 58 1 1 0]
	[local210 4] = [1420 60 1 0]
	[local214 10] = [1420 61 1 1 1 2 1 1 3 0]
	[local224 5] = [1420 68 1 1 0]
	[local229 6] = [1420 70 1 2 2 0]
	[local235 15] = [1420 73 1 2 3 1 1 1 2 2 2 2 2 2 0]
	[local250 4] = [1420 85 1 0]
	[local254 5] = [1420 86 1 1 0]
)

(instance jment of Rm
	(properties
		picture 420
		style -32758
	)

	(method (init)
		(Load rsPIC 420)
		(LoadMany rsVIEW 420 423 425 422 43 44 58 59 131 133 135 253 431 673)
		(LoadMany rsSOUND 5)
		(super init: &rest)
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(HandsOff)
		(gRgnMusic number: 5 loop: -1 play: hold: 1 fade: 127 6 12 0)
		(if (IsFlag 174)
			(gAddToPics add: poacher)
		)
		(if (IsFlag 173)
			(gAddToPics add: peasant)
		)
		(if (IsFlag 54)
			(gAddToPics add: beggar)
		)
		(if (IsFlag 62)
			(gAddToPics add: marianM)
		)
		(if (not (IsFlag 191))
			(gAddToPics add: yeoman)
		)
		(if (IsFlag 113)
			(gAddToPics add: jeweller)
		)
		(gAddToPics
			add:
				robinH
				guardR
				guardL
				guardD
				bench1
				bench2
				spect1
				spect2
				spect3
				spect4
				spect5
				spect6
				spect7
				spect8
				tuckie
				widow
				lobb
				fulkie
				sheriff
				abbot
				monk
				prior
			eachElementDo: #init
			doit:
		)
		(kingRichie init:)
		(scribe init:)
		(gCurRoom setScript: debateIssue)
	)
)

(instance robinH of PicView
	(properties
		x 88
		y 167
		view 420
		loop 10
		priority 11
		signal 16
	)
)

(instance guardR of PicView
	(properties
		x 100
		y 210
		view 420
		loop 9
		priority 14
		signal 16
	)
)

(instance guardL of PicView
	(properties
		x 13
		y 176
		view 420
		loop 9
		priority 13
		signal 16
	)
)

(instance guardD of PicView
	(properties
		x 73
		y 122
		view 420
		loop 9
		priority 0
		signal 16
	)
)

(instance bench1 of PicView
	(properties
		x 261
		y 187
		view 420
		loop 11
		priority 14
		signal 16
	)
)

(instance bench2 of PicView
	(properties
		x 297
		y 185
		view 420
		loop 11
		priority 14
		signal 16
	)
)

(instance spect1 of PicView
	(properties
		x 51
		y 32
		view 420
		loop 2
		priority 0
		signal 16
	)
)

(instance spect2 of PicView
	(properties
		x 99
		y 19
		view 420
		loop 3
		priority 0
		signal 16
	)
)

(instance spect3 of PicView
	(properties
		x 163
		y 9
		view 420
		loop 5
		priority 0
		signal 16
	)
)

(instance spect4 of PicView
	(properties
		x 208
		y 11
		view 420
		loop 5
		cel 1
		priority 0
		signal 16
	)
)

(instance spect5 of PicView
	(properties
		x 271
		y 18
		view 420
		loop 4
		priority 0
		signal 16
	)
)

(instance spect6 of PicView
	(properties
		x 304
		y 14
		view 420
		loop 4
		cel 1
		priority 0
		signal 16
	)
)

(instance spect7 of PicView
	(properties
		x 294
		y 189
		view 420
		loop 6
		priority 14
		signal 16
	)
)

(instance spect8 of PicView
	(properties
		x 253
		y 189
		view 420
		loop 7
		priority 14
		signal 16
	)
)

(instance marianM of PicView
	(properties
		x 127
		y 122
		view 423
		priority 8
		signal 16
	)
)

(instance tuckie of PicView
	(properties
		x 150
		y 111
		view 423
		loop 1
		priority 6
		signal 16
	)
)

(instance widow of PicView
	(properties
		x 163
		y 122
		view 423
		loop 2
		priority 6
		signal 16
	)
)

(instance lobb of PicView
	(properties
		x 113
		y 111
		view 423
		loop 3
		priority 6
		signal 16
	)
)

(instance poacher of PicView
	(properties
		x 143
		y 109
		view 423
		loop 5
		priority 6
		signal 16
	)
)

(instance peasant of PicView
	(properties
		x 140
		y 118
		view 423
		loop 6
		priority 7
		signal 16
	)
)

(instance yeoman of PicView
	(properties
		x 154
		y 100
		view 423
		loop 7
		priority 6
		signal 16
	)
)

(instance jeweller of PicView
	(properties
		x 104
		y 122
		view 423
		loop 8
		priority 7
		signal 16
	)
)

(instance beggar of PicView
	(properties
		x 177
		y 115
		view 423
		loop 9
		priority 0
		signal 16
	)
)

(instance fulkie of PicView
	(properties
		x 196
		y 117
		view 423
		loop 10
		priority 7
		signal 16
	)
)

(instance sheriff of PicView
	(properties
		x 251
		y 139
		view 425
		priority 9
		signal 16
	)
)

(instance abbot of PicView
	(properties
		x 266
		y 134
		view 425
		cel 1
		priority 8
		signal 16
	)
)

(instance monk of PicView
	(properties
		x 307
		y 135
		view 425
		cel 2
		priority 9
		signal 16
	)
)

(instance prior of PicView
	(properties
		x 292
		y 130
		view 425
		loop 1
		cel 3
		priority 8
		signal 16
	)
)

(instance scribe of Prop
	(properties
		x 268
		y 142
		view 420
		priority 9
		signal 16
	)
)

(instance kingRichie of Prop
	(properties
		x 212
		y 108
		view 422
		priority 6
		signal 16
	)
)

(instance debateIssue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(Converse 1 @local108 @local27 1 self) ; "Robin Hood, you and those you call your men stand accused of brigandage,..."
			)
			(2
				(gRgnMusic release:)
				(Converse 2 @local115 @local27 1 2 2 self) ; "M'lord, is it a crime to defy those who abuse your trust and use your laws to their own ends?"
			)
			(3
				(Converse 4 @local127 15 0 @local72 3 @local18 1 @local9 2 self) ; "By your leave, I shall speak first. I've served Robin Hood faithfully for many seasons."
			)
			(4
				(if (IsFlag 65)
					(Converse 1 @local140 @local9 2 self) ; "And this he did, with every mark entrusted to the Knight who brought it to the Queen."
				else
					(= ticks 6)
				)
			)
			(5
				(Converse 4 @local144 @local27 1 @local0 3 @local81 0 2 2 self) ; "I have since received an accounting of exactly the amount the outlaw sent and will weigh it in my judgement accordingly."
			)
			(6
				(if (IsFlag 61)
					(Converse 3 @local155 2 2 @local72 3 @local27 1 self) ; "Furthermore, I had also the Ring That Commands Fire, which had been taken by the Abbot."
				else
					(= ticks 6)
				)
			)
			(7
				(if (not (IsFlag 61))
					(Converse 1 @local161 @local27 1 self) ; "Where is this ring now?"
				else
					(= ticks 6)
				)
			)
			(8
				(Converse 3 @local165 2 2 12 3 @local27 1 self) ; "Ask yonder Sheriff. 'Twas he that took everything from me when I was captured."
			)
			(9
				(if (IsFlag 154)
					(Converse 3 @local171 @local81 0 @local0 3 2 2 self) ; "I would sooner take the word of Robin Hood over these rogues."
				else
					(= ticks 6)
				)
			)
			(10
				(if (not (IsFlag 154))
					(Converse 2 @local178 @local81 0 2 2 self) ; "I would sooner take the word of Robin Hood over these rogues."
				else
					(= ticks 6)
				)
			)
			(11
				(Converse 4 @local183 @local0 3 @local27 1 @local63 2 12 3 self) ; "I..ah...these things can all be explained--"
			)
			(12
				(if (IsFlag 173)
					(Converse 1 @local195 @local99 0 self) ; "God help the woman who seeks mercy at the hands of this Sheriff or his men!"
				else
					(= ticks 6)
				)
			)
			(13
				(if (IsFlag 174)
					(Converse 1 @local200 @local90 0 self) ; "Robin Hood saved me from the Sheriff's men. They accused me of poaching."
				else
					(= ticks 6)
				)
			)
			(14
				(if (and (IsFlag 54) (not (IsFlag 151)))
					(Converse 1 @local205 @local36 2 self) ; "He was not so good to me! He robbed me of every shred of rag I had and cared naught for my discomfort."
				else
					(= ticks 6)
				)
			)
			(15
				(if (and (IsFlag 54) (IsFlag 151))
					(Converse 1 @local210 @local36 2 self) ; "He treated me fairly. He gave me good money in exchange for my first set of rags."
				else
					(= ticks 6)
				)
			)
			(16
				(if (and (IsFlag 113) (not (IsFlag 152)))
					(Converse 3 @local214 @local54 0 2 2 @local27 1 self) ; "You'll hear no good of Robin Hood from me!"
				else
					(= ticks 6)
				)
			)
			(17
				(if (and (IsFlag 113) (IsFlag 152))
					(Converse 1 @local224 @local54 0 self) ; "I must say that for an outlaw he was most just and fair to me."
				else
					(= ticks 6)
				)
			)
			(18
				(if (not (IsFlag 191))
					(Converse 2 @local229 @local27 1 @local45 2 self) ; "Speak up, yeoman. Let your voice be heard."
				else
					(= ticks 6)
				)
			)
			(19
				(if (IsFlag 62)
					(Converse 3 @local235 @local27 1 21 0 @local72 3 self) ; "Lady Marian, you asked to speak last."
				else
					(= ticks 6)
				)
			)
			(20
				(Converse 1 @local250 @local27 1 self) ; "If there is anyone who has not yet spoken, let him stand forth."
			)
			(21
				(= ticks 96)
			)
			(22
				(Converse 1 @local254 @local27 1 self) ; "Very well. The witnessing is complete."
			)
			(23
				(= ticks 180)
			)
			(24
				(gRgnMusic fade: 60 6 12 0)
				(= ticks 72)
			)
			(25
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803)
				(= ticks 6)
			)
			(26
				(if (== global151 40)
					(gCurRoom newRoom: 422) ; hanging
				else
					(gCurRoom newRoom: 421) ; sentence
				)
				(self dispose:)
			)
		)
	)
)

