;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 851)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use Talker)
(use RandCycle)
(use Actor)
(use System)

(public
	Converse 0
	AyeOrNay 1
	talker1 2
	talker2 3
)

(local
	local0
	local1
	local2
	[local3 6]
	local9
	local10 = 1
	local11
	local12
	local13
	[local14 198] = [2 0 2 4 21 35 18 24 0 2 3 2 4 25 39 20 28 0 2 9 2 4 19 36 18 23 0 31 0 2 4 23 37 21 24 0 56 0 2 4 13 37 15 25 0 35 0 2 4 24 35 26 21 0 38 0 2 4 23 32 17 20 0 18 0 2 4 20 38 19 26 0 27 0 2 4 21 40 20 29 0 58 0 2 4 23 37 22 27 26 42 0 2 4 24 41 23 29 29 45 0 2 4 19 37 20 25 17 153 0 2 4 12 35 15 25 1 162 0 2 4 21 33 20 22 2 156 0 2 4 17 31 18 22 3 159 0 2 4 24 38 21 25 4 165 0 2 4 22 30 21 19 5 -1 {Guard} 19 0 0 0 0 0 0 -1 {Roger} 19 0 0 0 0 0 0 -1 {Giles} 19 0 0 0 0 0 0 209 0 2 4 22 39 19 29 9 209 3 2 4 27 34 26 25 9]
	[local212 4] = [13 245 13 245]
	[local216 4] = [12 12 107 107]
	[local220 4] = [94 30 94 30]
	[local224 4] = [30 30 125 125]
	[local228 9]
)

(procedure (Converse param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(talker1 nsTop: local216 nsLeft: local212 x: local220 y: local224)
	(if (u> param1 1000)
		(= local0 param1)
		(= local1 param2)
		(= local2 (if (> argc 2) param3 else 0))
		(= local9 (if (> argc 3) param4 else 0))
		(= local11 (WordAt local0 0))
		(= local13 (WordAt local0 1))
		(if
			(not
				(cond
					((> argc 5) param6)
					((and local9 (local9 respondsTo: #notKilled))
						(local9 notKilled:)
					)
					(else 1)
				)
			)
			(if local9
				(local9 cue: 0)
			)
			(return)
		)
		(Conversation register: 1 notKilled: 1)
		(= local1 (localproc_0 local1))
		(if (!= (WordAt local1 0) -1)
			(bust1
				view: (WordAt local1 0)
				loop: (+ (= temp0 (WordAt local1 1)) 1)
				nsLeft: (WordAt local1 2)
				nsTop: (WordAt local1 3)
			)
			(mouth1
				view: (WordAt local1 0)
				loop: temp0
				nsLeft: (WordAt local1 4)
				nsTop: (WordAt local1 5)
			)
			(eyes1
				view: (WordAt local1 0)
				loop: (+ (= temp0 (WordAt local1 1)) 2)
				nsLeft: (WordAt local1 6)
				nsTop: (WordAt local1 7)
			)
			(talker1 init: bust1 eyes1 mouth1)
		else
			(talker1 loop: 1 107 0 0 0)
		)
		(if local2
			(= local2 (localproc_0 local2))
			(if (!= (WordAt local2 0) -1)
				(bust2
					view: (WordAt local2 0)
					loop: (+ (= temp0 (WordAt local2 1)) 1)
					nsLeft: (WordAt local2 2)
					nsTop: (WordAt local2 3)
				)
				(mouth2
					view: (WordAt local2 0)
					loop: temp0
					nsLeft: (WordAt local2 4)
					nsTop: (WordAt local2 5)
				)
				(eyes2
					view: (WordAt local2 0)
					loop: (+ (= temp0 (WordAt local2 1)) 2)
					nsLeft: (WordAt local2 6)
					nsTop: (WordAt local2 7)
				)
				(talker2 init: bust2 eyes2 mouth2 script: Conversation)
			else
				(talker2 loop: 1 init: 0 0 0 script: Conversation)
			)
		)
		(= local10 (if (> argc 4) param5 else 1))
		(talker1 setScript: Conversation)
	else
		(= local228 param1)
		(= local0 param2)
		(for ((= temp0 1)) (<= temp0 local228) ((++ temp0))
			(= [local0 temp0] [param1 (* 2 temp0)])
			(= [local228 temp0] [param2 (* 2 temp0)])
			(= [local0 temp0] (localproc_0 [local0 temp0]))
		)
		(= local9
			(if (> argc (+ 2 (* 2 local228))) [param3 (* 2 local228)] else 0)
		)
		(= local11 (WordAt local0 0))
		(= local13 (WordAt local0 1))
		(crowd
			register: 1
			notKilled:
				(cond
					((> argc (+ 4 (* 2 local228))) [param5 (* 2 local228)])
					((and local9 (local9 respondsTo: #notKilled))
						(local9 notKilled:)
					)
					(else 1)
				)
		)
		(talker1 setScript: crowd)
	)
)

(procedure (localproc_0 param1)
	(if (u< param1 1000)
		(if (== param1 999)
			(= param1
				(switch gDisguiseNum
					(0 1) ; outlaw
					(1 7) ; beggar
					(2 4) ; jewler (no rouge)
					(3 5) ; jewler (rouge)
					(4 6) ; yeoman
					(5 9) ; abbey monk
					(6 8) ; fens monk
				)
			)
		)
		(= param1 (+ @local14 (* (-- param1) 18)))
	)
	(return param1)
)

(procedure (AyeOrNay)
	(gGame setCursor: 999 1)
	(Print {} #at -1 155 #button {Aye} 1 #button {Nay} 0 &rest)
)

(class RTEyeCycle of RandCycle
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 (/ (client cycleSpeed:) (if (client cel:) 30 else 1)))
		(if (> count (= temp0 (GetTime)))
			(if (> (- temp0 cycleCnt) temp1)
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(self cycleDone:)
		)
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(= count (+ (GetTime) param2))
			(if (>= argc 3)
				(= caller param3)
			)
		else
			(= count -1)
		)
	)

	(method (nextCel)
		(return (and (< (client cel:) (client lastCel:)) (+ 1 (client cel:))))
	)
)

(class RHTalker of Talker
	(properties)

	(method (startText param1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gGame setCursor: 5 (not (HaveMouse)))
		(= ticks (+ global162 (* global163 (StrLen param1))))
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: RTEyeCycle ticks)
		)
		(if loop
			(Print param1 #at x y #dispose #title name)
		else
			(Print param1 #at x y #dispose)
		)
	)

	(method (dispose)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view:)
				(mouth loop:)
				0
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				-1
			)
		)
		(= loop 0)
		(proc13_7)
		(super dispose: &rest)
	)
)

(class Conversation of Script
	(properties
		notKilled 1
	)

	(method (cue param1 &tmp temp0 [temp1 200])
		(if argc
			(= notKilled param1)
		)
		(if (and (= temp0 (WordAt local0 (++ register))) notKilled)
			(if (!= (WordAt [local0 temp0] 0) -1)
				(GetFarText local11 local13 @temp1)
				(SetMessageColor (WordAt [local0 temp0] 8))
				(switch temp0
					(1
						(talker1 say: @temp1 0 0 0 self)
					)
					(2
						(talker2 say: @temp1 0 0 0 self)
					)
				)
			else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetMessageColor (WordAt [local0 temp0] 2))
				(GetFarText local11 local13 @temp1)
				(switch temp0
					(1
						(talker1
							name: (WordAt [local0 temp0] 1)
							view: 805
							loop: 1
							bust: 0
							eyes: 0
							mouth: 0
							say: @temp1 0 0 0 self
						)
					)
					(2
						(talker2
							name: (WordAt [local0 temp0] 1)
							view: 805
							loop: 1
							bust: 0
							eyes: 0
							mouth: 0
							say: @temp1 0 0 0 self
						)
					)
				)
			)
			(++ local13)
		else
			(if (or local10 (not notKilled))
				(if (talker1 underBits:)
					(talker1 setScript: 0 dispose: 1)
				)
				(if (and local2 (talker2 underBits:))
					(talker2 script: 0 dispose: 1)
				)
			)
			(SetMessageColor 0)
			(if local9
				(local9 cue: notKilled)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				)
				(= notKilled 0)
			)
		)
	)
)

(instance crowd of Conversation
	(properties)

	(method (cue param1 &tmp temp0 temp1 [temp2 200])
		(if argc
			(= notKilled param1)
		)
		(if (and (= temp0 (WordAt local0 (++ register))) notKilled)
			(if (!= (WordAt [local0 temp0] 0) -1)
				(GetFarText local11 local13 @temp2)
				(SetMessageColor (WordAt [local0 temp0] 8))
				(bust1
					view: (WordAt [local0 temp0] 0)
					loop: (+ (= temp1 (WordAt [local0 temp0] 1)) 1)
					nsLeft: (WordAt [local0 temp0] 2)
					nsTop: (WordAt [local0 temp0] 3)
				)
				(mouth1
					view: (WordAt [local0 temp0] 0)
					loop: temp1
					nsLeft: (WordAt [local0 temp0] 4)
					nsTop: (WordAt [local0 temp0] 5)
				)
				(eyes1
					view: (WordAt [local0 temp0] 0)
					loop: (+ (= temp1 (WordAt [local0 temp0] 1)) 2)
					nsLeft: (WordAt [local0 temp0] 6)
					nsTop: (WordAt [local0 temp0] 7)
				)
				(talker1
					nsTop: [local216 [local228 temp0]]
					nsLeft: [local212 [local228 temp0]]
					x: [local220 [local228 temp0]]
					y: [local224 [local228 temp0]]
					init:
						bust1
						eyes1
						mouth1
						@temp2
						0
						0
						(!= temp0 (WordAt local0 (+ register 1)))
						self
				)
			else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetMessageColor (WordAt [local0 temp0] 2))
				(GetFarText local11 local13 @temp2)
				(talker1
					name: (WordAt [local0 temp0] 1)
					view: 805
					loop: 1
					bust: 0
					eyes: 0
					mouth: 0
					x: [local220 [local228 temp0]]
					y: [local224 [local228 temp0]]
					say: @temp2 0 0 1 self
				)
			)
			(++ local13)
		else
			(if (talker1 underBits:)
				(talker1 setScript: 0 dispose:)
			)
			(SetMessageColor 0)
			(if local9
				(local9 cue: notKilled)
			)
		)
	)
)

(instance talker1 of RHTalker
	(properties
		x 94
		y 30
		nsTop 12
		nsLeft 13
		view 805
		signal 16384
	)
)

(instance bust1 of View
	(properties
		nsTop 4
		nsLeft 3
		signal 16384
	)
)

(instance mouth1 of Prop
	(properties
		nsTop 31
		nsLeft 19
		loop 1
		priority 14
		signal 16400
		cycleSpeed 8
	)
)

(instance eyes1 of Prop
	(properties
		loop 1
		priority 14
		signal 16400
		cycleSpeed 180
	)
)

(instance talker2 of RHTalker
	(properties
		x 30
		y 125
		nsTop 107
		nsLeft 245
		view 805
		signal 16384
	)
)

(instance bust2 of View
	(properties
		nsTop 4
		nsLeft 3
		signal 16384
	)
)

(instance mouth2 of Prop
	(properties
		nsTop 31
		nsLeft 19
		loop 1
		priority 10
		signal 16400
		cycleSpeed 8
	)
)

(instance eyes2 of Prop
	(properties
		loop 1
		priority 10
		signal 16400
		cycleSpeed 180
	)
)

(class TScript of Script
	(properties
		notKilled 1
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(= notKilled
			(cond
				((>= argc 4) param4)
				((param1 respondsTo: #notKilled)
					(param1 notKilled:)
				)
				(else 1)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (cue param1)
		(if (and argc (not param1))
			(= notKilled 0)
		)
		(super cue: notKilled &rest)
	)

	(method (dispose &tmp temp0)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(if (IsObject client)
			(client
				script:
					(= temp0
						(cond
							((IsObject next) next)
							(next
								(ScriptID next)
							)
						)
					)
			)
			(cond
				((not temp0) 0)
				((== gNewRoomNum gCurRoomNum)
					(temp0 init: client)
				)
				(else
					(temp0 dispose:)
				)
			)
		)
		(if (and (IsObject caller) (== gNewRoomNum gCurRoomNum))
			(caller cue: notKilled)
		)
		(= script (= timer (= client (= next (= caller 0)))))
		(super dispose:)
	)
)

