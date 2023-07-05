;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use Talker)
(use RandCycle)
(use Motion)
(use Actor)

(class SQNarrator of Narrator
	(properties
		narratorBuf 0
		state 0
		narMod 0
		narNoun 0
		narVerb 0
		narCase 0
		narSeq 0
	)

	(method (say param1 param2 param3 param4 param5 param6 param7)
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& gMsgType $0001)
			(= narratorBuf (Str newWith: 400 (param1 data:)))
		)
		(if (& gMsgType $0002)
			(= narMod param3)
			(= narNoun param4)
			(= narVerb param5)
			(= narCase param6)
			(= narSeq param7)
		)
		(if (not initialized)
			(self init:)
		else
			(self sayForReal:)
		)
	)

	(method (sayForReal)
		(= state 1)
		(if (& gMsgType $0001)
			(self startText: narratorBuf)
		)
		(if (& gMsgType $0002)
			(self startAudio: narMod narNoun narVerb narCase narSeq)
		)
		(+= ticks (+ 60 gGameTime))
	)
)

(class SmallTalker of SQNarrator
	(properties
		body 0
		bodyView 0
		bodyLoop 0
		bodyCel 0
		talkView 0
		talkLoop 0
		client 0
		stopWalkTalk 1
		prepMove 0
		showTalk 1
	)

	(method (canTalk)
		(return 1)
	)

	(method (init)
		(super init:)
		(= disposeWhenDone 0)
		(cond
			(prepMove
				(= ticks -1)
				(= body
					((Prop new:)
						view: bodyView
						setLoop: bodyLoop
						setCel: bodyCel
						setPri: (client priority:)
						scaleSignal: (client scaleSignal:)
						scaleX: (client scaleX:)
						scaleY: (client scaleY:)
						x: (client x:)
						y: (client y:)
						z: (client z:)
						init:
						setCycle: End self
						yourself:
					)
				)
				(client hide:)
			)
			(showTalk
				(= body
					((Prop new:)
						view: talkView
						setLoop: talkLoop
						setCel: bodyCel
						setPri: (client priority:)
						scaleSignal: (client scaleSignal:)
						scaleX: (client scaleX:)
						scaleY: (client scaleY:)
						x: (client x:)
						y: (client y:)
						z: (client z:)
						init:
						hide:
						yourself:
					)
				)
				(self cue:)
			)
			(else
				(= body 0)
				(self cue:)
			)
		)
	)

	(method (startText &tmp temp0)
		(= temp0 (super startText: &rest))
		(if (and (not (& gMsgType $0002)) (or showTalk prepMove))
			(body
				view: talkView
				setLoop: talkLoop
				setCel: bodyCel
				show:
				setCycle: RandCycle (* (/ temp0 3) 2) 0 1
			)
			(client hide:)
		else
			(= ticks (* (/ temp0 3) 2))
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= audModNum param1)
		(= audNoun param2)
		(= audVerb param3)
		(= audCase param4)
		(= audSequence param5)
		(super startAudio: param1 param2 param3 param4 audSequence)
		(if (or showTalk prepMove)
			(body
				view: talkView
				setLoop: talkLoop
				setCel: bodyCel
				show:
				setCycle: TalkRandCycle
			)
			(client hide:)
		)
	)

	(method (cue)
		(cond
			((== state 0)
				(self sayForReal:)
			)
			((== state 2)
				(self realDispose:)
			)
		)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(= state 2)
			(= scratch 1)
			(if prepMove
				(body view: bodyView setLoop: bodyLoop)
				(body setCel: (body lastCel:) setCycle: Beg self)
			else
				(self realDispose:)
			)
		else
			(= scratch 0)
			(self realDispose:)
		)
	)

	(method (realDispose)
		(if (and (& gMsgType $0001) narratorBuf)
			(narratorBuf dispose:)
			(= narratorBuf 0)
		)
		(if curText
			(gTextScroller addString: {} 50 84 0)
			(gTextScroller addString: {} gUserFont 82 0)
			(strHandle dispose:)
			(= curText 0)
		)
		(cond
			(scratch
				(= state 0)
				(if (or prepMove showTalk)
					(client show:)
					(body dispose:)
					(= body 0)
				)
			)
			(body
				(body setCycle: 0 setCel: 0)
			)
		)
		(super dispose: scratch)
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp1 (Print new:))
		(temp1 x: 7 y: 192 font: gUserFont back: 0 modeless: 2 init:)
		(if gTextScroller
			(= strHandle (Str format: {%s\n} (self name:)))
			(gTextScroller addString: (strHandle data:) 50 84 0)
			(strHandle dispose:)
			(= strHandle (Str format: {%s\n\n} param1))
			(= curText (gTextScroller addString: (strHandle data:) gUserFont 82 0 0))
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)
)

