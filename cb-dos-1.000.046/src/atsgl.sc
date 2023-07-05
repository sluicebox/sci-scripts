;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 243)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	atsgl 0
	proc243_1 1
)

(synonyms
	(acres mansion cabin)
)

(local
	[local0 18] = [243 0 243 1 243 2 243 3 243 4 243 5 243 6 243 7 243 8]
	[local18 24] = [243 9 243 10 243 11 243 12 243 13 243 14 243 15 243 16 243 17 243 18 243 19 243 20]
	[local42 10] = ['ask//*<about>' 'tell//*<about>' 'show>' 'give>' 'look>' 'get>' 'kill>' 'kiss>' 'embrace>' 'flirt>']
	[local52 30] = ['/celie>' '/attorney>' '/colonel>' '/ethel>' '/fifi>' '/gertie>' '/actress>' '/butler>' '/lil>' '/rudolph>' '/c>' '/beauregard>' '/blaze>' '/bag>' '/bible>' '/bone>' '/cane>' '/butt>' '/diary>' '/valve,handle>' '/necklace>' '/magic>' '/diamond>' '/control>' '/parrot>' '/handkerchief>' '/sarah,(crouton<sarah)>' '/ghost>' '/acres>' '/crouton,frances,francois,claudette,s,claude,william>']
	[local82 11] = ['/*<celie>' '/*<attorney>' '/*<colonel>' '/*<ethel>' '/*<fifi>' '/*<gertie>' '/*<actress>' '/*<butler>' '/*<lil>' '/*<rudolph>' '/*<c>']
	[local93 30] = ['//celie>' '//attorney>' '//colonel>' '//ethel>' '//fifi>' '//gertie>' '//actress>' '//butler>' '//lil>' '//rudolph>' '//c>' '//beauregard>' '//blaze>' '//bag>' '//bible>' '//bone>' '//cane>' '//butt>' '//diary>' '//valve,handle>' '//necklace>' '//magic>' '//diamond>' '//control>' '//parrot>' '//handkerchief>' '//sarah,(crouton<sarah)>' '//ghost>' '//acres>' '//crouton,frances,francois,claudette,s,claude,william>']
	[local123 10] = [1 2 3 4 5 6 7 8 9 10]
	[local133 30] = [2 64 512 8 16 1 4 1024 32 256 128 8256 8320 8200 10240 8704 8196 9216 8224 8208 12288 16384 16385 8194 16388 16392 16400 16416 16448 16512]
	[local163 11] = [1 2 3 4 5 6 7 8 9 10 11]
	local174
	local175
	local176
	local177
	local178
)

(procedure (proc243_1 param1 &tmp temp0 temp1)
	(if (= temp1 (== global212 5))
		(if (and (< (& global210 $7fff) 2048) (not (& global207 global210)))
			(global209 claimed: 1)
			(|= global207 global210)
			(Say 0 &rest)
		)
	else
		(= local174 (+ (= local174 (* (- global213 1) 7)) (/ param1 16)))
		(= temp0 (<< $0001 (mod param1 16)))
		(global209 claimed: 1)
		(if (and (= temp1 (& [global225 local174] temp0)) (!= global211 16512))
			(= local178 (* (- global212 1) 2))
			(switch global213
				(2
					(+= local178 8)
				)
				(5
					(+= local178 16)
				)
			)
			(Say 1 [local18 local178] [local18 (++ local178)])
		else
			(|= [global225 local174] temp0)
			(Say 1 &rest)
		)
	)
	(if (atsgl client:)
		(return temp1)
	else
		(atsgl dispose:)
	)
)

(procedure (localproc_0)
	(= global212 (= global210 (= global211 0)))
	((atsgl client:) setScript: 0)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(for ((= temp0 0)) local175 ((++ temp0))
		(if (and (& local175 $0001) (= temp1 [global377 temp0]))
			(= global213 [local163 temp0])
			(if global211
				(atsgl setScript: (ScriptID temp1))
				((atsgl script:) handleEvent: param1)
			)
			(break)
		)
		(>>= local175 $0001)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(global209 claimed: 1)
	(if (and (not local175) (not (= local175 global214)))
		(= local175 global208)
	)
	(= global211 0)
	(localproc_1)
	(= temp0
		(+
			local178
			(switch global213
				(2 2)
				(5 4)
				(else 0)
			)
		)
	)
	(if local178
		(= local178 (* (+ temp0 (- param1 1)) 2))
	)
	(if (and (== param1 1) (> local178 5))
		(proc243_1 111 [local0 local178] [local0 (++ local178)])
	else
		(Say 1 [local0 local178] [local0 (++ local178)])
	)
)

(instance atsgl of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((== (event type:) evSAID)
				(= global210 (= global211 (= global212 0)))
				(= global209 event)
				(for ((= local174 0)) (< local174 10) ((++ local174))
					(if (Said [local42 local174])
						(= global212 [local123 local174])
						(SetFlag
							(switch global212
								(1 41)
								(2 42)
								(3 43)
								(else 44)
							)
						)
						(break)
					)
				)
				(cond
					((== global212 0)
						(localproc_0)
						(return)
					)
					((< global212 3)
						(= local176 11)
					)
					(else
						(= local176 30)
						(if (< global212 5)
							(= local177 1)
						)
					)
				)
				(cond
					((Said '/*>')
						(for
							((= local174 0))
							(< local174 local176)
							((++ local174))
							
							(if (Said [local52 local174])
								(= global210 [local133 local174])
								(break)
							)
						)
						(if
							(and
								(< global212 3)
								(or (not global210) (> global210 2048))
							)
							(localproc_0)
							(return)
						)
						(if (and local177 (not global210))
							(= global210 -2)
						)
					)
					((or (< global212 3) (== global212 10))
						(= global210 2048)
					)
					(else
						(localproc_0)
						(return)
					)
				)
				(if (Said '//*>')
					(= temp0 (= temp2 0))
					(for ((= local174 0)) (< local174 30) ((++ local174))
						(if (Said [local93 local174])
							(= temp1 [local133 local174])
							(|= global211 temp1)
							(++ temp2)
							(if (== temp1 16400)
								(break)
							)
							(if (< temp1 2048)
								(|= temp0 temp1)
							)
						)
					)
					(cond
						((and (== global212 10) global211)
							(= global210 global211)
							(= global211 0)
						)
						(
							(and
								(< global212 3)
								(& temp0 global208)
								(or
									(== global210 temp0)
									(== temp0 global208)
									(and (>= global210 2048) (not global214))
								)
							)
							(= local175 (& temp0 global208))
							(= local178 3)
							(localproc_2 global212)
							(localproc_0)
							(return)
						)
					)
				)
				(if (and (< global212 3) (> temp2 1) (> global211 2048))
					(if (< global210 2048)
						(= local175 global210)
					else
						(= local175 0)
					)
					(= local178 0)
					(localproc_2 1)
					(localproc_0)
					(return)
				)
				(if
					(and
						local177
						global210
						(not global211)
						(> (& global210 $7fff) 2048)
					)
					(= global211 global210)
					(= global210 0)
					(for ((= local174 0)) (< local174 11) ((++ local174))
						(if (Said [local82 local174])
							(|= global210 [local133 local174])
						)
					)
					(if (not global210)
						(= global210 2048)
					)
				)
				(if local177
					(if global224
						(cond
							((not global211)
								(if (> (& global210 $7fff) 2048)
									(= global210 2048)
								)
								(= global211 -2)
							)
							(
								(and
									(& global211 global208)
									(> (& global210 $7fff) 2048)
								)
								(= temp0 global210)
								(= global210 global211)
								(= global211 temp0)
							)
						)
					else
						(= global212 0)
					)
				)
				(if (and (< (& global210 $7fff) 2048) (= temp3 global210))
					(repeat
						(if (& temp3 $0001)
							(break)
						)
						(>>= temp3 $0001)
					)
					(if (>>= temp3 $0001)
						(Print 243 21) ; "Please Laura, only one person at a time!"
						(event claimed: 1)
						(localproc_0)
						(return)
					)
				)
				(if (and global212 (!= global211 global210))
					(if (== global212 5)
						(= global211 global210)
					)
					(= local175 0)
					(if (== global210 2048)
						(if
							(and
								(& global208 global211)
								(< (& global211 $7fff) 2048)
							)
							(= local175 (= global210 (^ global208 global211)))
						else
							(if (not global214)
								(= global214 global208)
							)
							(= local175 (= global210 global214))
						)
					else
						(= local175 (& global208 global210))
						(if (> global212 4)
							(= global211 local175)
						)
					)
					(if local175
						(localproc_1 event)
					)
				)
			)
		)
		(client setScript: 0)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 243)
	)
)

