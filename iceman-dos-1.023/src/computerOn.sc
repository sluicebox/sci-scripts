;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n828)
(use User)
(use Actor)
(use System)

(public
	computerOn 0
)

(local
	[local0 8]
	[local8 32] = [{} {DESTROY} {COONTZ} {DEGREE} {COURSE} {SHIP} {LATITUDE} {RUSSIAN} {REDWOOD} {4100} {TACTIC} {WAR} {STEER} {DIRECTLY} {ARIZONA} {OCEAN} {} {destroy} {coontz} {degree} {course} {ship} {latitude} {russian} {redwood} {4100} {tactic} {war} {steer} {directly} {arizona} {ocean}]
	[local40 12]
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
)

(procedure (localproc_0 param1 param2 param3 &tmp [temp0 30])
	(Format @temp0 &rest)
	(Display @temp0 dsCOORD param1 param2 dsCOLOR param3 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if [local55 temp0]
			(Display 386 2 dsRESTOREPIXELS [local55 temp0])
			(= [local55 temp0] 0)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(Format @local0 386 2)
	(if (GetInput @local0 15)
		(for ((= temp0 0)) (< temp0 12) ((+= temp0 2))
			(if (and [local40 temp0] (localproc_4 [local40 temp0]))
				(= local52 temp0)
				(return 1)
			)
		)
		(return 0)
	else
		(return 0)
	)
)

(procedure (localproc_3)
	(Format @local0 386 2)
	(if (GetInput @local0 15)
		(if (localproc_4 [local40 (+ local52 1)])
			(return 1)
		)
		(return 0)
	else
		(return 0)
	)
)

(procedure (localproc_4 param1)
	(cond
		((== (StrCmp @local0 [local8 (+ param1 0)]) 0)
			(return 1)
		)
		((== (StrCmp @local0 [local8 (+ param1 16)]) 0)
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(Format @local0 386 2)
	(if (GetInput @local0 2)
		(cond
			((== (StrCmp @local0 {Y}) 0)
				(return 1)
			)
			((== (StrCmp @local0 {y}) 0)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	else
		(return 0)
	)
)

(instance computerOn of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD) script)
				(script cue:)
			)
			((Said 'turn<off/computer')
				(if (OneOf state 2 3 4 6)
					(self changeState: 10)
				else
					(Print 386 0) ; "Read your messages!"
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(if (== (gIceKeyDownHandler indexOf: self) -1)
			(gIceKeyDownHandler addToFront: self)
		)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(= start 0)
		(HandsOn)
		(terminal dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= [local40 0] (>> (subMarine msg12:) $000c))
				(= [local40 1] (& (>> (subMarine msg12:) $0008) $000f))
				(= [local40 2] (& (>> (subMarine msg12:) $0004) $000f))
				(= [local40 3] (& (subMarine msg12:) $000f))
				(= [local40 4] (>> (subMarine msg34:) $000c))
				(= [local40 5] (& (>> (subMarine msg34:) $0008) $000f))
				(= [local40 6] (& (>> (subMarine msg34:) $0004) $000f))
				(= [local40 7] (& (subMarine msg34:) $000f))
				(= [local40 8] (>> (subMarine msg56:) $000c))
				(= [local40 9] (& (>> (subMarine msg56:) $0008) $000f))
				(= [local40 10] (& (>> (subMarine msg56:) $0004) $000f))
				(= [local40 11] (& (subMarine msg56:) $000f))
				(gEgo loop: 3)
				(= seconds 2)
			)
			(1
				(terminal init: setPri: 12)
				(= seconds 1)
			)
			(2
				(= register
					(Display 386 1 dsCOORD 15 10 dsCOLOR 11 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "US NAVY DECODING COMPUTER"
				)
				(= seconds 4)
			)
			(3
				(Display 386 2 dsRESTOREPIXELS register)
				(= register
					(Display 386 3 dsCOORD 15 10 dsCOLOR 15 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Enter primary word key"
				)
				(if (not (localproc_2))
					(++ local53)
					(++ local54)
				)
				(= cycles 15)
			)
			(4
				(Display 386 2 dsRESTOREPIXELS register)
				(= register
					(Display 386 4 dsCOORD 15 10 dsCOLOR 14 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Enter secondary word key"
				)
				(if (not (localproc_3 local52))
					(++ local53)
					(++ local54)
				)
				(= cycles 15)
			)
			(5
				(Display 386 2 dsRESTOREPIXELS register)
				(Print 386 5) ; "Having entered the primary and secondary word keys, you then type in the coded message."
				(= cycles 2)
			)
			(6
				(= register
					(Display 386 6 dsCOORD 15 10 dsCOLOR 2 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Decoded message is..."
				)
				(Print 386 7) ; "The computer deciphers the message."
				(= seconds 2)
			)
			(7
				(Display 386 2 dsRESTOREPIXELS register)
				(if local53
					(switch (mod local54 3)
						(0
							(self setScript: MSG7Script self)
						)
						(1
							(self setScript: MSG8Script self)
						)
						(2
							(self setScript: MSG9Script self)
						)
					)
					(= local53 0)
				else
					(switch (>> local52 $0001)
						(0
							(SetScore subMarine 407 1 3)
							(self setScript: MSG1Script self)
						)
						(1
							(SetScore subMarine 407 2 3)
							(self setScript: MSG2Script self)
						)
						(2
							(SetScore subMarine 407 4 3)
							(self setScript: MSG3Script self)
						)
						(3
							(SetScore subMarine 407 8 3)
							(self setScript: MSG4Script self)
						)
						(4
							(SetScore subMarine 407 16 3)
							(self setScript: MSG5Script self)
						)
						(5
							(SetScore subMarine 407 32 3)
							(self setScript: MSG6Script self)
						)
					)
				)
			)
			(8
				(= register
					(Display 386 8 dsCOORD 15 10 dsCOLOR 2 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Decode another message? Y or N"
				)
				(= start 3)
				(if (localproc_5)
					(self init:)
				else
					(= cycles 2)
				)
			)
			(9
				(Display 386 2 dsRESTOREPIXELS register)
				(= seconds 2)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance MSG1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 13 386 9))
				(= local56 (localproc_0 15 16 13 386 10))
				(= local57 (localproc_0 15 22 13 386 11))
				(= local58 (localproc_0 20 28 13 386 12))
				(= local59 (localproc_0 15 34 13 386 13))
				(= local60 (localproc_0 20 40 13 386 14))
				(= local61 (localproc_0 15 46 13 386 15))
				(= local62 (localproc_0 20 52 13 386 16))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 10 386 17))
				(= local56 (localproc_0 15 16 10 386 18))
				(= local57 (localproc_0 20 22 10 386 19))
				(= local58 (localproc_0 15 28 10 386 20))
				(= local59 (localproc_0 20 34 10 386 21))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 13 386 9))
				(= local56 (localproc_0 16 16 13 386 22))
				(= local57 (localproc_0 20 22 13 386 23))
				(= local58 (localproc_0 20 28 13 386 24))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 10 386 25))
				(= local56 (localproc_0 20 16 10 386 26))
				(= local57 (localproc_0 15 22 10 386 27))
				(= local58 (localproc_0 20 28 10 386 28))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG5Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 13 386 29))
				(= local56 (localproc_0 15 16 13 386 30))
				(= local57 (localproc_0 20 22 13 386 31))
				(= local58 (localproc_0 15 28 13 386 32))
				(= local59 (localproc_0 15 34 13 386 33))
				(= local60 (localproc_0 20 40 13 386 34))
				(= local61 (localproc_0 20 46 13 386 35))
				(= local62 (localproc_0 15 52 13 386 36))
				(= local63 (localproc_0 20 58 13 386 37))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG6Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 10 386 38))
				(= local56 (localproc_0 15 16 10 386 39))
				(= local57 (localproc_0 20 22 10 386 40))
				(= local58 (localproc_0 15 28 10 386 41))
				(= local59 (localproc_0 20 34 10 386 42))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG7Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 12 386 43))
				(= local56 (localproc_0 15 16 12 386 44))
				(= local57 (localproc_0 15 22 12 386 45))
				(= local58 (localproc_0 20 28 12 386 46))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG8Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 12 386 47))
				(= local56 (localproc_0 20 16 12 386 48))
				(= local57 (localproc_0 15 22 12 386 45))
				(= local58 (localproc_0 20 28 12 386 49))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG9Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (localproc_0 15 10 12 386 50))
				(= local56 (localproc_0 20 16 12 386 51))
				(= local57 (localproc_0 20 22 12 386 52))
				(= local58 (localproc_0 15 28 12 386 53))
				(= local59 (localproc_0 20 34 12 386 54))
				(= local60 (localproc_0 20 40 12 386 55))
				(= local61 (localproc_0 20 46 12 386 56))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance terminal of View
	(properties
		y 79
		x 73
		view 31
		loop 4
	)

	(method (delete)
		(super delete:)
		(DisposeScript 386)
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

