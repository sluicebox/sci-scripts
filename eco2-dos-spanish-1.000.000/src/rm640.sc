;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use Bats)
(use Print)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	local0 = 1023
	local1
	local2
	local3
	local4 = 9
	local5
	local6
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 &tmp temp0 temp1 temp2 temp3 temp4)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) param13 param5 param12)
	(= temp1 param1)
	(= temp2 param2)
	(= temp3 param4)
	(= temp4 param3)
	(-= param1 param10)
	(-= param2 param10)
	(+= param4 param10)
	(+= param3 param10)
	(Graph grFILL_BOX param1 param2 (+ param1 param10) param4 param13 param6 param12)
	(Graph grFILL_BOX (- param3 param10) param2 param3 param4 param13 param8 param12)
	(for ((= temp0 0)) (< temp0 param10) ((++ temp0))
		(Graph
			grDRAW_LINE
			(+ param1 temp0)
			(+ param2 temp0)
			(- param3 (+ temp0 1))
			(+ param2 temp0)
			param7
			param12
			-1
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp0)
			(- param4 (+ temp0 1))
			(- param3 (+ temp0 1))
			(- param4 (+ temp0 1))
			param9
			param12
			-1
		)
	)
	(if param11
		(Graph
			grFILL_BOX
			(+ param1 param11)
			param4
			(+ param3 param11)
			(+ param4 param11)
			param13
			0
			param12
		)
		(Graph
			grFILL_BOX
			param3
			(+ param2 param11)
			(+ param3 param11)
			param4
			param13
			0
			param12
		)
	)
	(Graph
		grUPDATE_BOX
		(- temp1 param10)
		(- temp2 param10)
		(+ temp4 param10 param11)
		(+ temp3 param10 param11)
		1
	)
)

(procedure (localproc_1)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 2 1 curIcon: (gTheIconBar at: 2))
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0 temp1 [temp2 80])
	(= temp0 0)
	(if (not param4)
		(= local5 1)
		(while local5
			(++ param4)
			(if (Message msgGET 640 param1 param2 param3 param4 @temp2)
				(localproc_0 122 82 175 238 5 7 6 3 4 3 2 -1 1)
				(Display @temp2 dsCOLOR 21 dsCOORD 87 127 dsWIDTH 152 dsFONT gUserFont)
				(for
					((= temp1 (Event new:)))
					(not (OneOf (temp1 type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN))
					((= temp1 (Event new:)))
					
					(temp1 dispose:)
					(= gGameTime (+ gTickOffset (GetTime)))
					(gSounds eachElementDo: #check)
					(gSounds eachElementDo: #doit)
				)
			else
				(break)
			)
			(temp1 dispose:)
		)
	else
		(localproc_0 122 82 175 238 5 7 6 3 4 3 2 -1 1)
		(Message msgGET 640 param1 param2 param3 param4 @temp2)
		(Display @temp2 dsCOLOR 21 dsCOORD 87 127 dsWIDTH 152 dsFONT gUserFont)
	)
	(if param5
		(param5 cue:)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(= temp1 0)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& (>> local0 (- 9 temp0)) $0001)
			(if (== temp1 param1)
				(return temp0)
			else
				(++ temp1)
			)
		)
	)
	(Prints {SEARCH NOT FOUND})
	(return (SetDebug))
)

(procedure (localproc_4 param1)
	(switch param1
		(0
			(= local1 0)
			(return 10)
		)
		(1
			(= local1 1)
			(return 6)
		)
		(2
			(= local1 2)
			(return 12)
		)
		(3
			(= local1 3)
			(return 14)
		)
		(4
			(= local1 4)
			(return 16)
		)
		(5
			(= local1 5)
			(return 18)
		)
		(6
			(= local1 6)
			(return 20)
		)
		(7
			(= local1 7)
			(return 22)
		)
		(8
			(= local1 8)
			(return 24)
		)
		(9
			(= local1 9)
			(return 8)
		)
	)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3)
	(if (not local4)
		(localproc_4 (localproc_3 0))
		(return)
	)
	(if local3
		(= temp3 local0)
		(&= local0 (~ (>> $0200 local1)))
	)
	(= temp1
		(Random
			0
			(if local3
				(- local4 1)
			else
				local4
			)
		)
	)
	(= temp2 (localproc_3 temp1))
	(if local3
		(= local0 temp3)
	else
		(= local3 1)
	)
	(localproc_4 temp2)
)

(procedure (localproc_6 param1)
	(switch param1
		(0
			(return 11)
		)
		(1
			(return 7)
		)
		(2
			(return 13)
		)
		(3
			(return 15)
		)
		(4
			(return 17)
		)
		(5
			(return 19)
		)
		(6
			(return 21)
		)
		(7
			(return 23)
		)
		(8
			(return 25)
		)
		(9
			(return 9)
		)
	)
)

(procedure (localproc_7)
	(if (mod local4 2)
		(jagHead cel: (+ (jagHead cel:) 1))
	)
	(cond
		((and (not (leg1 cycler:)) (== (leg1 loop:) 2))
			(leg1 setCycle: Fwd)
		)
		((== (leg1 loop:) 2)
			(leg1 setLoop: 3 cel: 0 setCycle: CT 3 1 (doPlay script:))
			(gGameSound1 hold: 2)
		)
		((and (not (leg2 cycler:)) (== (leg2 loop:) 4))
			(leg2 setCycle: Fwd)
		)
		((== (leg2 loop:) 4)
			(leg2 setLoop: 5 cel: 0 setCycle: CT 3 1 (doPlay script:))
			(gGameSound1 hold: 3)
		)
		((and (not (leg3 cycler:)) (== (leg3 loop:) 6))
			(leg3 setCycle: Fwd)
		)
		((== (leg3 loop:) 6)
			(leg3 setLoop: 7 cel: 0 setCycle: CT 3 1 (doPlay script:))
			(gGameSound1 hold: 4)
		)
		((and (not (leg4 cycler:)) (== (leg4 loop:) 8))
			(leg4 setCycle: Fwd)
		)
		((== (leg4 loop:) 8)
			(leg4 setLoop: 9 cel: 0 setCycle: CT 3 1 (doPlay script:))
		)
		((and (not (jagTail cycler:)) (== (jagTail loop:) 10))
			(jagTail setCycle: Fwd)
		)
		(else
			(jagTail setLoop: 11 cel: 0 setCycle: End (doPlay script:))
		)
	)
)

(instance rm640 of Rm
	(properties
		noun 5
		picture 888
		style 10
	)

	(method (init)
		(gGame handsOff:)
		(LoadMany rsVIEW 670)
		(gGameSound1 number: 636 play: hold: 1)
		(jugar init:)
		(star init:)
		(cloud init:)
		(bird init:)
		(snake init:)
		(ant init:)
		(leave init:)
		(flower init:)
		(moon init:)
		(sun init:)
		(frog init:)
		(jagHead init:)
		(leg1 init:)
		(leg2 init:)
		(leg3 init:)
		(leg4 init:)
		(jagTail init:)
		(super init:)
		(self setScript: doPlay)
	)

	(method (doVerb))

	(method (dispose)
		(gCurrentRegionFlags set: 3)
		(super dispose:)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_2 5 0 (localproc_4 local1) 1 0)
		)
		(super doit:)
	)
)

(instance quest1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 5 0 register 1 self)
			)
			(1)
			(2
				(if (not (mod local4 2))
					(self cue:)
				)
			)
			(3
				(if (not (mod local4 2))
					(self cue:)
				else
					(= seconds 2)
				)
			)
			(4
				(localproc_2 5 0 1 0 self)
			)
			(5
				(self dispose:)
				(doPlay cue:)
			)
		)
	)
)

(instance quest2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 5 0 3 0 self)
			)
			(1
				(localproc_2 5 0 register 1 self)
			)
			(2)
			(3
				(if (not (mod local4 2))
					(self cue:)
				)
			)
			(4
				(if (not (mod local4 2))
					(self cue:)
				else
					(= seconds 2)
				)
			)
			(5
				(localproc_2 5 0 1 0 self)
			)
			(6
				(self dispose:)
				(doPlay cue:)
			)
		)
	)
)

(instance doPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(localproc_2 5 0 5 0 self)
			)
			(2
				(localproc_1)
				(self setScript: (quest1 new:) 0 (localproc_5))
			)
			(3
				(= local2 0)
				(if (not local0)
					(self cue:)
				else
					(self changeState: 2)
				)
			)
			(4
				(localproc_2 5 0 2 0 self)
			)
			(5
				(gCast eachElementDo: #addToPic)
				(= cycles 5)
			)
			(6
				(gGameSound1 number: 638 setLoop: 1 play:)
				((Prop new:)
					view: 670
					loop: 0
					cel: 0
					x: 84
					y: 53
					signal: 16384
					init:
					setPri: 15
					setCycle: End self
				)
			)
			(7
				(= ticks 90)
			)
			(8
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance jugar of View
	(properties
		x 82
		y 19
		noun 2
		view 663
		priority 1
		signal 16400
	)

	(method (init)
		(super init:)
		(self stopUpd: addToPic:)
	)

	(method (doVerb))
)

(instance star of Prop
	(properties
		x 35
		y 19
		noun 6
		view 663
		loop 12
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 6)) ; Do
			(cond
				((== local1 0)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $fdff)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cloud of Prop
	(properties
		x 35
		y 45
		noun 7
		view 663
		loop 12
		cel 1
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 7)) ; Do
			(cond
				((== local1 1)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $feff)
					(-- local4)
					(self startUpd: cel: 10)
					(Animate (gCast elements:) 0)
					(localproc_7)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bird of Prop
	(properties
		x 35
		y 71
		noun 8
		view 663
		loop 12
		cel 2
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 8)) ; Do
			(cond
				((== local1 2)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $ff7f)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance snake of Prop
	(properties
		x 35
		y 97
		noun 9
		view 663
		loop 12
		cel 3
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 9)) ; Do
			(cond
				((== local1 3)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $ffbf)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ant of Prop
	(properties
		x 35
		y 123
		noun 10
		view 663
		loop 12
		cel 4
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 10)) ; Do
			(cond
				((== local1 4)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $ffdf)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leave of Prop
	(properties
		x 260
		y 19
		noun 11
		view 663
		loop 12
		cel 5
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 11)) ; Do
			(cond
				((== local1 5)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $ffef)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance flower of Prop
	(properties
		x 260
		y 45
		noun 16
		view 663
		loop 12
		cel 6
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 16)) ; Do
			(cond
				((== local1 6)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $fff7)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance moon of Prop
	(properties
		x 260
		y 71
		noun 13
		view 663
		loop 12
		cel 7
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 13)) ; Do
			(cond
				((== local1 7)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $fffb)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sun of Prop
	(properties
		x 260
		y 97
		noun 14
		view 663
		loop 12
		cel 8
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 14)) ; Do
			(cond
				((== local1 8)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $fffd)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance frog of Prop
	(properties
		x 260
		y 123
		noun 15
		view 663
		loop 12
		cel 9
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (== noun 15)) ; Do
			(cond
				((== local1 9)
					(gGame handsOff:)
					(Bats points: 1)
					(&= local0 $fffe)
					(-- local4)
					(self startUpd: cel: 10)
					(localproc_7)
					(Animate (gCast elements:) 0)
					(self stopUpd: noun: 1)
					((doPlay script:) cue:)
				)
				((not local2)
					(= local2 1)
					(self setScript: (quest2 new:) 0 (localproc_6 local1))
				)
				(else
					(localproc_2 5 0 4 0 doPlay)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance jagHead of Prop
	(properties
		x 149
		y 66
		view 663
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance leg1 of Prop
	(properties
		x 169
		y 105
		view 663
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance leg2 of Prop
	(properties
		x 134
		y 95
		view 663
		loop 4
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance leg3 of Prop
	(properties
		x 237
		y 97
		view 663
		loop 6
		priority 8
		signal 16400
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance leg4 of Prop
	(properties
		x 160
		y 81
		view 663
		loop 8
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance jagTail of Prop
	(properties
		x 215
		y 98
		view 663
		loop 10
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

