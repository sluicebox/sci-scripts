;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Teller)
(use Talker)
(use Feature)
(use GameControls)
(use Game)
(use User)
(use System)

(public
	rm102 0
)

(local
	[local0 4] = [0 -2 -3 999]
	[local4 6] = [0 4 5 6 7 999]
	[local10 5] = [0 -8 -9 -10 999]
	[local15 6] = [0 11 12 13 14 999]
	[local21 6] = [0 15 16 17 18 999]
	[local27 5] = [0 19 20 -21 999]
	[local32 7] = [0 25 26 28 23 24 999]
	[local39 8] = [0 -2 -3 -8 -9 -10 -21 999]
	[local47 8]
)

(instance rm102 of Rm
	(properties
		picture 130
	)

	(method (init)
		(User canInput: 1)
		(gGame setCursor: 999)
		(super init: &rest)
		(= [local47 0] @local0)
		(= [local47 1] @local4)
		(= [local47 2] @local10)
		(= [local47 3] @local15)
		(= [local47 4] @local21)
		(= [local47 5] @local27)
		(= [local47 6] @local32)
		(Narrator talkWidth: 250)
		(infoTeller init: info @local0 @local47 @local39)
		(info init:)
		(Animate (gCast elements:) 0)
		(infoTeller doVerb: 2)
	)
)

(instance infoTeller of Teller
	(properties)

	(method (respond)
		(= query (self showDialog:))
		(if (and (!= query -999) iconValue)
			(= query iconValue)
		)
		(cond
			((== query -999)
				(return (gCurRoom newRoom: 130))
			)
			((== query 999)
				(self doParent:)
				(return 0)
			)
			((and (< query 0) (not (self doChild: query)))
				(return 1)
			)
		)
		(= query (Abs query))
		(gMessager say: (client noun:) 5 query 0 self)
		(return 1)
	)

	(method (cue)
		(self doVerb: 2)
	)

	(method (doDialog param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 30])
		(= temp0 [param1 (= temp3 0)])
		(= temp5 5)
		(= temp8 0)
		(= temp4 0)
		(= temp9 (List new:))
		((= theControls (GameControls new:))
			window:
				((GloryWindow new:)
					top: 40
					left: (proc0_21 45 85 55 45 85)
					bottom: 140
					right: (proc0_21 275 235 265 275 235)
					priority: 15
					yourself:
				)
		)
		(if (OneOf curArray @local0 @local10)
			(+= temp5 15)
		)
		(for ((= temp2 1)) (!= (WordAt curArray temp2) 999) ((++ temp2))
			(= temp6 1)
			(for ((= temp3 1)) (and temp6 (< temp3 argc)) ((+= temp3 2))
				(if
					(and
						(== (WordAt curArray temp2) [param1 temp3])
						(not [param1 (+ temp3 1)])
					)
					(= temp6 0)
				)
			)
			(if temp6
				(= temp7 (WordAt curArray temp2))
				(= temp14 (self getSeqNum: (Abs temp7)))
				(if
					(not
						(= temp13
							(Message
								msgSIZE
								gCurRoomNum
								(client noun:)
								2
								(Abs temp7)
								temp14
							)
						)
					)
					(break)
				)
				(= temp1 (Memory memALLOC_NONCRIT temp13))
				(temp9 add: temp1)
				(Message msgGET gCurRoomNum (client noun:) 2 (Abs temp7) temp14 temp1)
				((= temp4 (infoIcon new:))
					myHandle: temp1
					value: temp7
					nsTop: temp5
					myTeller: self
				)
				(if (!= client gEgo)
					(temp4 notEgo: 1)
				)
				(theControls add: temp4)
				(++ temp8)
				(+= temp5 15)
			)
		)
		(if (not (IsObject temp4))
			((theControls window:) dispose:)
			(theControls dispose:)
			(temp9 dispose:)
			(return -999)
		)
		(= temp4 (infoIcon new:))
		(if (not temp0)
			(Message msgGET 23 0 0 2 1 @temp15) ; "Something Else"
			(temp4 myHandle: @temp15 value: 999 nsTop: temp5 myTeller: self)
		else
			(Message msgGET 23 0 0 3 1 @temp15) ; "Enough Already"
			(temp4 myHandle: @temp15 value: -999 nsTop: temp5 myTeller: self)
		)
		(theControls add: temp4)
		((theControls window:)
			top: (- 60 (* 7 temp8))
			bottom: (- (+ temp5 80) (* 7 temp8))
		)
		(theControls init: show: dispose:)
		(for
			((= temp10 (FirstNode (temp9 elements:))))
			temp10
			((= temp10 temp11))
			
			(= temp11 (NextNode temp10))
			(if (not (= temp12 (NodeValue temp10)))
				(break)
			else
				(Memory memFREE temp12)
			)
		)
		(return (temp9 dispose:))
	)

	(method (doChild param1)
		(switch param1
			(-2 ; "Technical Info"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(-3 ; "Game Information"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(-8 ; "Use Icon Bars"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(-9 ; "Fight Monsters"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(-10 ; "Do Things"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(-21 ; "Get Hints"
				(super doChild: param1)
				(self cue:)
				(return 0)
			)
			(else
				(return 1)
			)
		)
	)
)

(instance info of Feature
	(properties
		x 160
		y 100
		noun 1
		nsBottom 199
		nsRight 319
	)
)

(instance infoIcon of TellerIcon
	(properties)

	(method (show &tmp [temp0 15])
		(if notEgo
			(cond
				((== (infoTeller curArray:) @local0)
					(Message msgGET 102 1 2 1 1 @temp0) ; "Do You Want..."
					(Display @temp0 dsCOORD (proc0_21 20 15 20 20 15) 5 dsCOLOR 17)
				)
				((== (infoTeller curArray:) @local10)
					(Message msgGET 102 1 2 22 1 @temp0) ; "How to..."
					(Display @temp0 dsCOORD (proc0_21 20 15 20 20 15) 5 dsCOLOR 17)
				)
			)
		)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)
)

