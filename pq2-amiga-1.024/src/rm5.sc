;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm5 0
)

(synonyms
	(flyer cheeks painting)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 3]
)

(procedure (localproc_0)
	(Print &rest #at -1 130)
)

(instance rm5 of Rm
	(properties
		picture 5
		style 7
	)

	(method (init)
		(super init:)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 67)
		(self setLocales: 153)
		(= global212 3)
		(HandsOn)
		(= local5 0)
		(= local6 0)
		(self setScript: rm5Script)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look>')
					(cond
						((Said '[<at,around][/(!*,chamber,bathroom)]')
							(localproc_0 5 0 70 220) ; "The locker room has three rows of full-sized lockers, two benches, a wash basin with mirror, and four toilet stalls."
						)
						((Said '[<at,up][/ceiling]')
							(localproc_0 5 1) ; "You look at the ceiling and observe a lighting system that adequately illuminates the locker room."
						)
						((Said '[<at,down][/floor]')
							(localproc_0 5 2) ; "You look down and see a very clean floor."
						)
					)
				)
			)
		)
	)
)

(instance rm5Script of Script
	(properties)

	(method (doit)
		(cond
			((and (<= 120 (gEgo x:) 160) (<= 150 (gEgo y:) 155))
				(gCurRoom newRoom: 2)
			)
			((<= (gEgo y:) 126)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User prevDir: 1)
				(gEgo
					view: (if (not global204) 1 else 7)
					posn: 141 148
					setPri: -1
					init:
					setMotion: MoveTo 141 140
					setCycle: Walk
					illegalBits: $8000
				)
				((= local0 (Prop new:))
					view: 67
					posn: 84 115
					cel: 0
					init:
					stopUpd:
				)
				((View new:)
					view: 64
					loop: 0
					cel: 1
					posn: 178 110
					setPri: 7
					init:
					addToPic:
				)
				((View new:)
					view: 64
					loop: 0
					cel: 0
					posn: 168 129
					setPri: 9
					init:
					ignoreActors:
				)
				((View new:)
					view: 64
					loop: 2
					cel: 0
					posn: 239 127
					setPri: 7
					init:
					ignoreActors: 0
				)
				((View new:)
					view: 64
					loop: 2
					cel: 0
					posn: 259 132
					setPri: 7
					init:
					ignoreActors: 0
				)
				((= local4 (Prop new:))
					view: 64
					loop: 1
					cel: 0
					posn: 216 124
					setPri: 7
					init:
					ignoreActors:
					stopUpd:
				)
			)
			(1
				(local0 startUpd: cycleSpeed: 2 init: setCycle: End self)
			)
			(2
				(gCurRoom setScript: lockerScript)
			)
			(3
				(gEgo
					posn: 94 118
					view: 0
					loop: 1
					cel: 6
					setCycle: Walk
					init:
				)
				(local0
					view: 67
					posn: 84 115
					startUpd:
					cycleSpeed: 2
					cel: 4
					setCycle: Beg
					init:
				)
				(gCurRoom drawPic: 5)
			)
			(4
				(HandsOff)
				(local4 setCycle: End self)
			)
			(5
				(local4 stopUpd:)
				(gEgo
					setPri: 6
					illegalBits: 0
					setMotion: MoveTo 210 120 self
				)
			)
			(6
				(gEgo setMotion: MoveTo 221 123 self)
			)
			(7
				(User canInput: 1)
				(local4 setCycle: Beg)
			)
			(8
				(switch (Random 0 2)
					(0
						(localproc_0 5 3) ; "Aaahhh! That feels good."
					)
					(1
						(localproc_0 5 4) ; "You hum a tune as you relieve yourself. "Strangers in the night, la da dee dah...""
					)
					(2
						(localproc_0 5 5) ; "You hold your breath for the duration."
					)
				)
			)
			(9
				(HandsOff)
				(= local7 0)
				(local4 setCycle: End self)
			)
			(10
				(gEgo setMotion: MoveTo 210 120 self)
			)
			(11
				(gEgo setPri: -1 setMotion: MoveTo 195 123 self)
			)
			(12
				(HandsOn)
				(gEgo illegalBits: $8000)
				(local4 setCycle: Beg self)
			)
			(13
				(local4 stopUpd:)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				local6
				(or
					(== (event message:) KEY_F6)
					(== (event message:) KEY_F8)
					(== (event message:) $3a00)
				)
			)
			(event claimed: 1)
			(localproc_0 5 6) ; "You can't right now."
		)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'pick/lock')
				(localproc_0 5 7) ; "The lock on your locker is is not the type that you can pick."
			)
			((Said 'stand')
				(if (not local7)
					(localproc_0 5 8) ; "You already are."
				else
					(localproc_0 5 9) ; "Ok."
					(= local7 0)
				)
			)
			((Said 'sat')
				(cond
					(local6
						(gEgo loop: 1)
						(localproc_0 5 9 83) ; "Ok."
						(= local7 1)
					)
					((gEgo inRect: 77 100 195 135)
						(localproc_0 5 10) ; "The crud on the bench changes your mind."
					)
					(else
						(localproc_0 5 11) ; "You are not close enough to the bench."
					)
				)
			)
			((Said 'get/crud')
				(if (gEgo inRect: 77 100 195 135)
					(localproc_0 5 12) ; "You don't need it."
				else
					(localproc_0 5 11) ; "You are not close enough to the bench."
				)
			)
			((Said 'move/bench')
				(if (gEgo inRect: 77 100 195 135)
					(localproc_0 5 13) ; "You can't move something that's anchored to the floor."
				else
					(localproc_0 5 11) ; "You are not close enough to the bench."
				)
			)
			((Said 'climb/bench')
				(if (gEgo inRect: 77 100 195 135)
					(localproc_0 5 14) ; "Negative!"
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $00e0))
					(Said 'look,read/locker,door,label,name')
				)
				(switch (gEgo onControl: 1)
					(4
						(localproc_0 5 15) ; "The name on the locker reads: "S. Bonds""
					)
					(8192
						(localproc_0 5 16) ; "The name on the locker reads: "J. Pierson""
					)
					(4096
						(localproc_0 5 17) ; "The name on the locker reads: "K. Robinson""
					)
					(2048
						(localproc_0 5 18) ; "The name on the locker reads: "J. Dooley""
					)
					(1024
						(localproc_0 5 19) ; "The name on the locker reads: "J. Simpson""
					)
					(512
						(localproc_0 5 20) ; "The name on the locker reads: "R. Adams""
					)
					(256
						(localproc_0 5 21) ; "The name on the locker reads: "W. Jerome""
					)
					(8
						(localproc_0 5 22) ; "The name on the locker reads: "S. Jones""
					)
					(16
						(localproc_0 5 23) ; "The name on the locker reads: "L. Pratt""
					)
					(else
						(localproc_0 5 24) ; "Get closer to a locker."
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '/crud')
						(localproc_0 5 25) ; "The crud is black and green and yellow and nothing you want to mess with."
					)
					((Said '/pane')
						(localproc_0 5 26) ; "Through the window you see a clear day."
					)
					((Said '<below/bench')
						(localproc_0 5 27) ; "Under the bench you see the floor."
					)
					((Said '/bench')
						(localproc_0 5 28) ; "You see nothing special about the bench."
					)
					((Said '<below/door,stall')
						(cond
							((& (gEgo onControl: 1) $0020)
								(switch (Random 0 2)
									(0
										(localproc_0 5 29) ; "You see trousers crumpled on the floor around a pair of legs, and you conclude that the stall is occupied."
									)
									(1
										(localproc_0 5 30) ; "My gawd! Get serious !"
									)
									(2
										(localproc_0 5 31) ; "Pervert!"
									)
								)
							)
							((& (gEgo onControl: 1) $00c0)
								(localproc_0 5 32) ; "You see nothing but a toilet."
							)
							(else
								(localproc_0 5 33) ; "You are not close enough to a stall."
							)
						)
					)
					((Said '/crapper,stall')
						(if local6
							(localproc_0 5 34) ; "A somewhat clean, but not very interesting toilet is in the stall."
						else
							(localproc_0 5 35) ; "You can't see it from here."
						)
					)
					((and (& (gEgo onControl: 1) $00e0) (Said '/door'))
						(localproc_0 5 36) ; "Nothing special about this door."
					)
					((Said '/lock,combination')
						(if (& (gEgo onControl: 1) $0004)
							(localproc_0 5 37) ; "Your lock is the round type that unlocks by turning to three numbers in the correct sequence."
						else
							(localproc_0 5 38) ; "You're not close enough to your locker."
						)
					)
					((Said '/mirror')
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 5 39) ; "You look into the mirror and see your mother's son."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said '/basin[<bath]')
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 5 40) ; "You see gleaming white porcelain."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
				)
			)
			((Said 'crawl<below/door,stall')
				(if (& (gEgo onControl: 1) $00e0)
					(localproc_0 5 41) ; "These aren't bus station pay toilets."
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said 'talk/man,cop')
				(if (or local6 (& (gEgo onControl: 1) $0120))
					(switch (Random 0 3)
						(0
							(localproc_0 5 42) ; "Speaking laboriously, the stalls occupant says, "Roses are red, violets are fun, hey man, hey man, I have constipation!""
						)
						(1
							(localproc_0 5 43) ; "Excuse me, but this is not a place for conversation."
						)
						(2
							(localproc_0 5 44) ; "I'm meditating, leave me alone."
						)
						(3
							(localproc_0 5 45) ; "I have more important things to do."
						)
					)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said 'knock')
				(cond
					((== (gEgo onControl: 1) 32)
						(switch (Random 0 4)
							(0
								(localproc_0 5 46) ; "Hearing the sound of rustling paper, you accurately surmise that this stall's occupant is concentrating deeply!"
							)
							(1
								(localproc_0 5 47) ; "Grunts and groans encourage you to leave!"
							)
							(2
								(localproc_0 5 48) ; "From behind the door you hear the occupant whistling a familiar tune. At least he enjoys his handiwork."
							)
							(3
								(localproc_0 5 49) ; "A voice snaps back, "This crapper's occupied!""
							)
							(4
								(localproc_0 5 50) ; "Use the next stall ! I'm giving birth to another sergeant!"
							)
						)
					)
					((& (gEgo onControl: 1) $00e0)
						(localproc_0 5 51) ; "This one is not occupied."
					)
					(else
						(localproc_0 5 52) ; "You are not close enough to the toilet door."
					)
				)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $00e0))
					(Said 'unlock,open/lock,locker,door')
				)
				(if (!= (gEgo onControl: 1) 4)
					(localproc_0 5 53) ; "Get closer to your locker."
				else
					(= [local8 0] (GetNumber {First # of your combination?}))
					(= [local8 1] (GetNumber {Second # of your combination?}))
					(= [local8 2] (GetNumber {Third # of your combination?}))
					(if
						(and
							(== [local8 0] 36)
							(== [local8 1] 4)
							(== [local8 2] 12)
						)
						(self changeState: 1)
						(SetScore 5 59)
					else
						(switch (Random 0 2)
							(0
								(localproc_0 5 54) ; "Are you sure about your combination numbers?"
							)
							(1
								(localproc_0 5 55) ; "You'd better try again."
							)
							(2
								(localproc_0 5 56) ; "Do you know your locker combination?"
							)
						)
					)
				)
			)
			(
				(or
					(Said 'open/door,stall')
					(and (not local6) (Said 'enter/bathroom,stall,crapper'))
				)
				(cond
					((& (gEgo onControl: 1) $0040)
						(localproc_0 5 57) ; "The door must be broken. You can't use this one."
					)
					((& (gEgo onControl: 1) $0020)
						(localproc_0 5 58) ; "This one is occupied."
					)
					((not (& (gEgo onControl: 1) $00e0))
						(localproc_0 5 52) ; "You are not close enough to the toilet door."
					)
					(local6
						(= local6 0)
						(rm5Script changeState: 9)
					)
					(else
						(= local6 1)
						(rm5Script changeState: 4)
					)
				)
			)
			((Said 'exit,(get<out)[/stall,crapper]')
				(if local6
					(= local6 0)
					(rm5Script changeState: 9)
				else
					(event claimed: 0)
				)
			)
			((Said 'open/pane')
				(localproc_0 5 59) ; "You don't need to."
			)
			(
				(or
					(Said 'use,go/crapper,bathroom')
					(Said 'shit,leak,shit,shit')
					(Said 'pull<down/jeans')
				)
				(if local6
					(rm5Script changeState: 8)
				else
					(localproc_0 5 60) ; "You'd better go inside the stall first."
				)
			)
			((or (Said 'wipe/ass') (Said 'shake/cock') (Said 'flush/crapper'))
				(if local6
					(localproc_0 5 61) ; "Good idea!"
				else
					(localproc_0 5 60) ; "You'd better go inside the stall first."
				)
			)
			((or (Said 'use/basin') (Said 'bath/hand,face'))
				(if (& (gEgo onControl: 1) $4000)
					(localproc_0 5 62) ; "You wash, rinse, and dry your face and hands."
				else
					(localproc_0 5 63) ; "You'd better get closer to the sink."
				)
			)
			((Said 'dry/hand')
				(localproc_0 5 59) ; "You don't need to."
			)
			((Said 'turn<on/water,faucet')
				(if (== (gEgo onControl: 1) 16384)
					(if (not local5)
						(= local5 1)
						(localproc_0 5 64) ; "You turn on the water and wash your hands."
					else
						(localproc_0 5 65) ; "The water is on already."
					)
				else
					(localproc_0 5 66) ; "The spigot is out of reach."
				)
			)
			((Said 'turn<off/water,faucet')
				(if (== (gEgo onControl: 1) 16384)
					(if local5
						(= local5 0)
						(localproc_0 5 67) ; "Good idea !"
					else
						(proc0_7) ; "You're not close enough."
					)
				else
					(localproc_0 5 66) ; "The spigot is out of reach."
				)
			)
			((Said 'drink/water')
				(localproc_0 5 68) ; "If you're thirsty, save the game, get out of your chair, and walk to your refrigerator."
			)
			((or (Said 'close[/locker,door]') (Said 'lock[/locker,door]'))
				(if (== (gEgo onControl: 1) 4)
					(localproc_0 5 69) ; "Your locker is already closed and locked."
				else
					(localproc_0 5 70) ; "You are not close enough to your locker."
				)
			)
			((Said 'find/locker')
				(localproc_0 5 71) ; "You can do that yourself."
			)
		)
	)
)

(instance lockerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 69)
				(Load rsVIEW 64)
				(Load rsPIC 9)
				(User canInput: 1)
				(gCurRoom drawPic: 9)
				(gCast eachElementDo: #dispose)
				((= local1 (Act new:))
					view: 69
					posn: 146 189
					setPri: 13
					loop: 0
					cel: 0
					init:
					stopUpd:
				)
				(if (not (IsItemAt 0)) ; hand_gun
					(local1 posn: 146 1189)
				)
				((= local2 (Act new:))
					view: 69
					posn: 227 41
					setPri: 12
					loop: 5
					cel:
						(switch global207
							(0
								(+ 2 (> [global215 1] 0) (> [global215 2] 0))
							)
							(1
								(> [global215 2] 0)
							)
							(else
								(> [global215 1] 0)
							)
						)
					init:
					stopUpd:
				)
				(if (not (IsItemAt 1)) ; extra_ammo_clips
					(local2 posn: 227 1041)
				)
				((= local3 (Act new:))
					view: 69
					posn: 216 136
					setPri: 13
					loop: 0
					cel: 1
					init:
					stopUpd:
				)
				(if (not (IsItemAt 8)) ; handcuffs
					(local3 posn: 216 1136)
				)
				((View new:)
					view: 69
					posn: 219 102
					setPri: 12
					loop: 2
					cel: 0
					init:
					stopUpd:
				)
				((View new:)
					view: 69
					posn: 100 102
					setPri: 12
					loop: 3
					cel: 0
					init:
					stopUpd:
				)
				((View new:)
					view: 69
					posn: 156 76
					setPri: 12
					loop: 1
					cel: 0
					init:
					stopUpd:
				)
				((View new:)
					view: 69
					posn: 50 156
					setPri: 12
					loop: 4
					cel: 0
					init:
					stopUpd:
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(or
					(== (event message:) KEY_F6)
					(== (event message:) KEY_F8)
					(== (event message:) $3a00)
				)
			)
			(event claimed: 1)
			(localproc_0 5 6) ; "You can't right now."
		)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said '(replace,remove,drop)>')
				(cond
					((Said '/gunbelt,9mm')
						(if (not (gEgo has: 0)) ; hand_gun
							(localproc_0 5 72) ; "You don't have that."
						else
							(localproc_0 5 73) ; "You unstrap and remove your holster. With its familiar weight gone, you feel off-balance and vulnerable."
							(local1 posn: 146 189)
							(PutItem 0) ; hand_gun
						)
					)
					((Said '/arrest')
						(if (not (gEgo has: 8)) ; handcuffs
							(localproc_0 5 72) ; "You don't have that."
						else
							(localproc_0 5 74) ; "You put the handcuffs back in the locker."
							(local3 posn: 216 136)
							(PutItem 8) ; handcuffs
						)
					)
					((Said '/bullet,ammo,(clip[<ammo])')
						(if (not (gEgo has: 1)) ; extra_ammo_clips
							(localproc_0 5 72) ; "You don't have that."
						else
							(localproc_0 5 75) ; "You put the ammo clips back in the locker."
							(local2
								cel:
									(switch global207
										(0
											(+
												2
												(> [global215 1] 0)
												(> [global215 2] 0)
											)
										)
										(1
											(> [global215 2] 0)
										)
										(else
											(> [global215 1] 0)
										)
									)
								posn: 227 41
							)
							(PutItem 1) ; extra_ammo_clips
						)
					)
					((= temp0 (gInventory saidMe: event))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 5 76) ; "You don't need to put that in the locker."
						else
							(proc0_9) ; "You don't have it."
						)
					)
					(else
						(event claimed: 1)
						(proc0_10) ; "You can't do that now."
					)
				)
			)
			((Said 'get,remove>')
				(cond
					((Said '/gunbelt,9mm')
						(if (IsItemAt 0) ; hand_gun
							(localproc_0 5 77) ; "You strap your holster on under your jacket."
							(local1 posn: 100 1000)
							(gEgo get: 0) ; hand_gun
							(SetScore 1 60)
						else
							(localproc_0 5 78) ; "Your gun isn't in the locker."
						)
					)
					((Said '/bullet,ammo,(clip[<ammo])')
						(if (IsItemAt 1) ; extra_ammo_clips
							(localproc_0 5 79) ; "You take your ammo clips."
							(gEgo get: 1) ; extra_ammo_clips
							(SetScore 1 62)
							(local2 posn: 100 1000)
						else
							(localproc_0 5 80) ; "There are no ammo clips in this locker."
						)
					)
					((Said '/arrest')
						(if (IsItemAt 8) ; handcuffs
							(localproc_0 5 81) ; "You put your handcuffs on your belt."
							(gEgo get: 8) ; handcuffs
							(SetScore 1 61)
							(local3 posn: 100 1000)
						else
							(localproc_0 5 82) ; "Your handcuffs are not in the locker"
						)
					)
					((Said '/flyer')
						(localproc_0 5 83) ; "You don't need the picture of Marie. It looks fine where it is."
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '[<at,around,in][/locker]')
						(gInventory
							carrying: {Your locker contains:}
							empty: {Your locker is empty.}
							showSelf: 5
						)
					)
					((Said '/bookcase')
						(if (IsItemAt 1) ; extra_ammo_clips
							(localproc_0 5 84) ; "On the shelf you see your spare ammo clips."
						else
							(localproc_0 5 85) ; "The shelf has nothing on it."
						)
					)
					((Said '/flyer')
						(localproc_0 5 86) ; "You took this picture at the beach. Marie has signed it: `Love, Marie'. What a girl!"
					)
					((Said '/bullet,ammo,(clip[<ammo])')
						(if (IsItemAt 1) ; extra_ammo_clips
							(localproc_0 5 87) ; "Your spare ammo is on the shelf."
						else
							(event claimed: 0)
						)
					)
					((Said '/9mm,gunbelt')
						(if (IsItemAt 0) ; hand_gun
							(localproc_0 5 88) ; "Your gun and holster are on a hook."
						else
							(event claimed: 0)
						)
					)
					((Said '/arrest')
						(if (IsItemAt 8) ; handcuffs
							(localproc_0 5 89) ; "Your pair of handcuffs are on a hook."
						else
							(event claimed: 0)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'kiss/flyer,flyer,button')
				(localproc_0 5 90) ; "You look around to make sure no one is watching and kiss Marie's belly button."
				(localproc_0 5 91) ; "You decide that it isn't a bit like the real thing."
			)
			((or (Said 'lock,close[/locker,door]') (Said 'exit'))
				(gCurRoom drawPic: (gCurRoom picture:))
				(gCast eachElementDo: #dispose)
				(HandsOn)
				(gCurRoom setScript: rm5Script)
				(rm5Script changeState: 3)
			)
		)
	)
)

